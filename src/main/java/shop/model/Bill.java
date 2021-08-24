package shop.model;

public class Bill {
	private int id;
	private String name;
	private String phone;
	private String address;
	private double amount;	
	private String des;
	public Bill() {
		super();
	}
	
	public Bill(String name, String phone, String address, double amount, String des) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.amount = amount;
		this.des = des;
	}
	
	public Bill(int id, String name, String phone, String address, double amount, String des) {
		this(name, phone, address, amount, des);
		this.id = id;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
