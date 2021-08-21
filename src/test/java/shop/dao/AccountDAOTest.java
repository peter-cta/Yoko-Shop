package shop.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import shop.model.Account;

class AccountDAOTest {
	private DriverManagerDataSource dataSource;
	private AccountDAO dao;
	
	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testGetId() {
	  dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/YokoShop");
      dataSource.setUsername("root");
      dataSource.setPassword("chuanh255");
      
      dao = new AccountDAOImpl(dataSource);
      String username = "theanh";
      int id = dao.getId(username);
      System.out.println("id : "+id);
      assertTrue(id > 0);
      
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}

	@Test
	void testLogin() {
		fail("Not yet implemented");
	}

}
