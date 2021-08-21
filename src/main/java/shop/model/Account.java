package shop.model;

public class Account {
	private Integer id;
	private String username;
	private String password;
	private String position;
	private Boolean enable;
	
	public Account() {
		super();
	}

	public Account(Integer id, String username, String password, String position, Boolean enable) {
		this(username, password, position, enable);
		this.id = id;

	}
	public Account(String username, String password, String position, Boolean enable) {

		this.username = username;
		this.password = password;
		this.position = position;
		this.enable = enable;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
}
