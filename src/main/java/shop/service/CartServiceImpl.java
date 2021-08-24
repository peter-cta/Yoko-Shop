package shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.CartDAO;
import shop.model.Cart;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public int save(Cart c) {
		// TODO Auto-generated method stub
		return cartDAO.save(c);
	}

	@Override
	public int update(Cart c) {
		// TODO Auto-generated method stub
		return cartDAO.update(c);
	}

	@Override
	public Cart get(Integer id) {
		// TODO Auto-generated method stub
		return cartDAO.get(id);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return cartDAO.delete(id);
	}

	@Override
	public List<Cart> list() {
		// TODO Auto-generated method stub
		return cartDAO.list();
	}

	@Override
	public Cart getCartFromAcc(int accId) {
		// TODO Auto-generated method stub
		return cartDAO.getCartFromAcc(accId);
	}

	@Override
	public int updatePrice(int cartID, double price) {
		// TODO Auto-generated method stub
		return cartDAO.updatePrice(cartID, price);
	}


}
