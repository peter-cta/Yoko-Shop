package shop.service;

import java.util.List;

import shop.model.Cart;

public interface CartService {
	public int save(Cart c);
	public int update(Cart c);
	public Cart get(Integer id);
	public int delete(Integer id);
	public List<Cart> list();
	public Cart getCartFromAcc(int accId);
	public int updatePrice(int cartID, double price);
}
