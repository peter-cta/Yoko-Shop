package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import shop.model.Cart;
import shop.model.CartItems;
import shop.model.Product;

@Repository
public class CartItemsDAOImpl implements CartItemsDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CartItemsDAOImpl(JdbcTemplate jdbc) {
		this.jdbcTemplate =jdbc;
		
	}
	
	
	@Override
	public int save(CartItems c) {
		String sql = "INSERT INTO CartItems (quantity, bill_id, cart_id, product_id) VALUES(?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getQuantity(), c.getBill_id(), c.getCart_id(), c.getProduct_id());
	
	}

	@Override
	public int update(CartItems c) {
		String sql = "UPDATE CartItems Set quantity = ?, bill_id = ?, cart_id = ?, product_id = ? WHERE id = ?";
		return jdbcTemplate.update(sql, c.getQuantity(), c.getBill_id(), c.getCart_id(), c.getProduct_id(), c.getId());
	}

	@Override
	public CartItems get(Integer id) {
		String sql = "Select * from CartItems where id = "+id;
		
		ResultSetExtractor<CartItems> extractor = new  ResultSetExtractor<CartItems>() {

			@Override
			public CartItems extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Integer quantity = rs.getInt("quantity");
					Integer bill_id = rs.getInt("bill_id");
					Integer cart_id = rs.getInt("cart_id");	
					Integer product_id = rs.getInt("product_id");		
					return new CartItems(id,quantity,bill_id,cart_id,product_id);
				}
				return null;
				
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "Delete from CartItems where id = "+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<CartItems> list() {
		String sql = "SELECT * FROM CartItems where bill_id=0";
		
		RowMapper<CartItems> rowMapper = new RowMapper<CartItems>() {
		
			@Override
			public CartItems mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Integer quantity = rs.getInt("quantity");
				Integer bill_id = rs.getInt("bill_id");
				Integer cart_id = rs.getInt("cart_id");	
				Integer product_id = rs.getInt("product_id");		
				return new CartItems(id,quantity,bill_id,cart_id,product_id);		
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}


	@Override
	public List<CartItems> getIteminCart(int cartID) {
		String sql = "SELECT * FROM CartItems where cart_id="+cartID+" and bill_id=0";
		
		RowMapper<CartItems> rowMapper = new RowMapper<CartItems>() {
		
			@Override
			public CartItems mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Integer quantity = rs.getInt("quantity");
				Integer bill_id = rs.getInt("bill_id");
				Integer cart_id = rs.getInt("cart_id");	
				Integer product_id = rs.getInt("product_id");		
				return new CartItems(id,quantity,bill_id,cart_id,product_id);		
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}


	@Override
	public int deleteItems(int productId) {
		String sql = "Delete from CartItems where product_id = "+productId;
		return jdbcTemplate.update(sql);
	}


	@Override
	public CartItems getFromCartID(int cartID) {
		String sql = "Select * from CartItems where cart_id = "+cartID+" and bill_id=0";
		
		ResultSetExtractor<CartItems> extractor = new  ResultSetExtractor<CartItems>() {

			@Override
			public CartItems extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Integer id = rs.getInt("id");
					Integer quantity = rs.getInt("quantity");
					Integer bill_id = rs.getInt("bill_id");
					Integer cart_id = rs.getInt("cart_id");	
					Integer product_id = rs.getInt("product_id");		
					return new CartItems(id,quantity,bill_id,cart_id,product_id);
				}
				return null;
				
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public List<CartItems> getIteminBill(int cartID, int billID) {
		String sql = "SELECT * FROM CartItems where cart_id="+cartID+" and bill_id="+billID;
		
		RowMapper<CartItems> rowMapper = new RowMapper<CartItems>() {
		
			@Override
			public CartItems mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Integer quantity = rs.getInt("quantity");
				Integer bill_id = rs.getInt("bill_id");
				Integer cart_id = rs.getInt("cart_id");	
				Integer product_id = rs.getInt("product_id");		
				return new CartItems(id,quantity,bill_id,cart_id,product_id);		
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}


	@Override
	public List<CartItems> getIteminBill(int billID) {
		String sql = "SELECT * FROM CartItems where bill_id="+billID;
		
		RowMapper<CartItems> rowMapper = new RowMapper<CartItems>() {
		
			@Override
			public CartItems mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Integer quantity = rs.getInt("quantity");
				Integer bill_id = rs.getInt("bill_id");
				Integer cart_id = rs.getInt("cart_id");	
				Integer product_id = rs.getInt("product_id");		
				return new CartItems(id,quantity,bill_id,cart_id,product_id);		
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

}
