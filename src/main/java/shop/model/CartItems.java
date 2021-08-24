package shop.model;

public class CartItems {
	private int id;
	private int quantity;
	private int bill_id;
	private int cart_id;
	private int product_id;
	public CartItems() {
		super();
	}
	
	public CartItems(int id, int quantity, int bill_id, int cart_id, int product_id) {
		this(quantity, bill_id, cart_id, product_id);
		this.id = id;
		
	}
	
	public CartItems(int quantity,int bill_id, int cart_id, int product_id) {
		this.quantity = quantity;
		this.bill_id = bill_id;
		this.cart_id = cart_id;
		this.product_id = product_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	
	
	
}
