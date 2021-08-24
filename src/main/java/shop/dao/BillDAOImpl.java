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

import shop.model.Bill;

@Repository
public class BillDAOImpl implements BillDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public BillDAOImpl(JdbcTemplate jdbc) {
		this.jdbcTemplate =jdbc;	
	}
	
	
	
	@Override
	public int save(Bill bill) {
		String sql = "INSERT INTO Bill (name, phone, address, amount, des) VALUES(?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, bill.getName(), bill.getPhone(), bill.getAddress(), bill.getAmount() , bill.getDes());
	
	}

	@Override
	public int update(Bill bill) {
		String sql = "UPDATE Bill Set  name = ?, phone = ?, address = ?, amount = ?, des = ?  WHERE id = ?";
		return jdbcTemplate.update(sql, bill.getName(), bill.getPhone(), bill.getAddress(), bill.getAmount() , bill.getDes(), bill.getId());
	}

	@Override
	public Bill get(Integer id) {
		String sql = "Select * from Bill where id = "+id;
		
		ResultSetExtractor<Bill> extractor = new  ResultSetExtractor<Bill>() {

			@Override
			public Bill extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					double amount = rs.getDouble("amount");					
					String des = rs.getString("des");	
					return new Bill(id,name,phone,address,amount,des);
				}
				return null;
				
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "Delete from Bill where id = "+id;
		return jdbcTemplate.update(sql);
	}



	@Override
	public List<Bill> list() {
		String sql = "SELECT * FROM Bill";
		
		RowMapper<Bill> rowMapper = new RowMapper<Bill>() {
		
			@Override
			public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				double amount = rs.getDouble("amount");					
				String des = rs.getString("des");	
				return new Bill(id,name,phone,address,amount,des);		
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}



	@Override
	public Bill getTopBill() {
		String sql = "SELECT * FROM Bill WHERE id = (SELECT MAX(id) FROM Bill)";
		
		ResultSetExtractor<Bill> extractor = new  ResultSetExtractor<Bill>() {

			@Override
			public Bill extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Integer id = rs.getInt("id");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					double amount = rs.getDouble("amount");					
					String des = rs.getString("des");	
					return new Bill(id,name,phone,address,amount,des);
				}
				return null;
				
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

}
