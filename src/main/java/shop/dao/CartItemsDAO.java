package shop.dao;

import java.util.List;

import shop.model.CartItems;
import shop.model.Product;

public interface CartItemsDAO {
	public int save(CartItems c);
	public int update(CartItems c);
	public CartItems get(Integer id);
	public int delete(Integer id);
	public List<CartItems> list();
	public List<CartItems> getIteminCart(int cartID);
	public int deleteItems(int productId);
	public CartItems getFromCartID(int cartID); 
	public List<CartItems> getIteminBill(int cartID, int billID);
	public List<CartItems> getIteminBill(int billID);
}
