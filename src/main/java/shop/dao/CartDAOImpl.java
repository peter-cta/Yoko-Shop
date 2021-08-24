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

import shop.model.Brand;
import shop.model.Cart;

@Repository
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CartDAOImpl(JdbcTemplate jdbc) {
		this.jdbcTemplate =jdbc;
		
	}
	
	@Override
	public int save(Cart c) {
		String sql = "INSERT INTO Cart (total, account_id) VALUES(?, ?)";
		return jdbcTemplate.update(sql, c.getTotal(), c.getAccount_id());
	
	}

	@Override
	public int update(Cart c) {
		String sql = "UPDATE Cart Set total = ?, account_id = ? WHERE id = ?";
		return jdbcTemplate.update(sql, c.getTotal(), c.getAccount_id(), c.getId());
	}

	@Override
	public Cart get(Integer id) {
		String sql = "Select * from Cart where id = "+id;
		
		ResultSetExtractor<Cart> extractor = new  ResultSetExtractor<Cart>() {

			@Override
			public Cart extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Double total = rs.getDouble("total");	
					Integer account_id = rs.getInt("account_id");		
					return new Cart(id,total,account_id);
				}
				return null;
				
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "Delete from Cart where id = "+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Cart> list() {
		String sql = "SELECT * FROM Cart";
		
		RowMapper<Cart> rowMapper = new RowMapper<Cart>() {
		
			@Override
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Double total = rs.getDouble("total");	
				Integer account_id = rs.getInt("account_id");		
				return new Cart(id,total,account_id);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Cart getCartFromAcc(int accId) {
		String sql = "Select * from Cart where account_id = "+accId;
		
		ResultSetExtractor<Cart> extractor = new  ResultSetExtractor<Cart>() {

			@Override
			public Cart extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Integer id = rs.getInt("id");
					Double total = rs.getDouble("total");	
					Integer account_id = rs.getInt("account_id");		
					return new Cart(id,total,account_id);
				}
				return null;				
			}			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int updatePrice(int cartID, double price) {
		String sql = "UPDATE Cart Set total = ? WHERE id = ?";
		return jdbcTemplate.update(sql, price, cartID);
	
	}

	
}
