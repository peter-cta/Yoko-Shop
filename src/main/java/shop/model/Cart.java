package shop.model;

public class Cart {
	private Integer id;
	private Double total;
	private Integer account_id;
	public Cart() {
		super();
	}
	
	public Cart(Integer id, Double total, Integer account_id) {
		this(total, account_id);
		this.id = id;
	}
	
	public Cart(Double total, Integer account_id) {
		this.total = total;
		this.account_id = account_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

		
}
