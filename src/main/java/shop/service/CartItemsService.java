package shop.service;

import java.util.List;

import shop.model.CartItems;
import shop.model.Product;

public interface CartItemsService {
	public int save(CartItems c);
	public int update(CartItems c);
	public CartItems get(Integer id);
	public int delete(Integer id);
	public List<CartItems> list();
	public List<Product> getProdutcInCart(int accId);
	public void addToCart(CartItems cartItems);
	public int deleteItems(int productId);
	public List<CartItems> getIteminCart(int id);
	public int increaseQty(int cartItemId);
	public int reduceQty(int cartItemId);
	public List<Product> getProdutcInBill(int cartID, int billID);
	public List<CartItems> getIteminBill(int cartID, int billID);
//	public int calTotal(int cartId);
}
