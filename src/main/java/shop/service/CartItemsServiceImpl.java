package shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.CartDAO;
import shop.dao.CartItemsDAO;
import shop.dao.CustomerDAO;
import shop.dao.ProductDAO;
import shop.model.Cart;
import shop.model.CartItems;
import shop.model.Product;

@Service
public class CartItemsServiceImpl implements CartItemsService{
	
	@Autowired
	private CartItemsDAO cartItemsDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public int save(CartItems c) {
		// TODO Auto-generated method stub
		return cartItemsDAO.save(c);
	}

	@Override
	public int update(CartItems c) {
		// TODO Auto-generated method stub
		return cartItemsDAO.update(c);
	}

	@Override
	public CartItems get(Integer id) {
		// TODO Auto-generated method stub
		return cartItemsDAO.get(id);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return cartItemsDAO.delete(id);
	}

	@Override
	public List<CartItems> list() {
		// TODO Auto-generated method stub
		return cartItemsDAO.list();
	}

	@Override
	public List<Product> getProdutcInCart(int accId) {
		List<Product> listPro = new ArrayList<Product>() ;
		Cart cart = cartDAO.getCartFromAcc(accId);
		double total = 0;
		List<CartItems> listItems = cartItemsDAO.getIteminCart(cart.getId());
		for (CartItems ci : listItems) {
			Product pro = new Product();
			pro = productDAO.get(ci.getProduct_id());
			listPro.add(pro);
			total = total + ci.getQuantity() * pro.getPrice();
		}
		cartDAO.updatePrice(cart.getId(), total);
		return listPro;
	}

	@Override
	public void addToCart(CartItems cartItems) {
		List<CartItems> listItems = cartItemsDAO.getIteminCart(cartItems.getCart_id());
		int kt = 0;
		for (CartItems items : listItems) {
			if(items.getProduct_id() == cartItems.getProduct_id()) {
				kt = 1;
				items.setQuantity(items.getQuantity()+1);
				cartItemsDAO.update(items);
				break;
			}
		}
		if(kt == 0) {
			cartItemsDAO.save(cartItems);
		}
	}

	@Override
	public int deleteItems(int productId) {
		// TODO Auto-generated method stub
		return cartItemsDAO.deleteItems(productId);
	}

	@Override
	public List<CartItems> getIteminCart(int id) {
		// TODO Auto-generated method stub
		return cartItemsDAO.getIteminCart(id);
	}
	
	@Override
	public int increaseQty(int cartItemId) {
		// TODO Auto-generated method stub
		CartItems item = cartItemsDAO.get(cartItemId);
		item.setQuantity(item.getQuantity() + 1);
		cartItemsDAO.update(item);
		return 1;
	}

	@Override
	public int reduceQty(int cartItemId) {
		CartItems item = cartItemsDAO.get(cartItemId);
		if(item.getQuantity() == 1) {
			cartItemsDAO.delete(item.getId());
		}else {
			item.setQuantity(item.getQuantity() -1);
			cartItemsDAO.update(item);
		}
		return 1;
	}

	@Override
	public List<Product> getProdutcInBill(int cartID, int billID) {
		// TODO Auto-generated method stub
		List<Product> listPro = new ArrayList<Product>() ;
		List<CartItems> listItems = cartItemsDAO.getIteminBill(cartID, billID);
		for (CartItems ci : listItems) {
			Product pro = new Product();
			pro = productDAO.get(ci.getProduct_id());
			listPro.add(pro);
		}
		return listPro;
	}

	@Override
	public List<CartItems> getIteminBill(int cartID, int billID) {
		// TODO Auto-generated method stub
		return cartItemsDAO.getIteminBill(cartID, billID);
	}

//	@Override
//	public int calTotal(int cartId) {
//		// TODO Auto-generated method stub
//		List<CartItems> listItems = cartItemsDAO.getIteminCart(cartId);
//		double total = 0;
//		for (CartItems ci : listItems) {
//			Product pro = new Product();
//			pro = productDAO.get(ci.getProduct_id());
//			total = total + ci.getQuantity() * pro.getPrice();
//		}
//		cartDAO.updatePrice(cartId, total);
//		return 1;
//	}

}
