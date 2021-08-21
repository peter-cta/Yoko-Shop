package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import shop.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AccountDAOImpl(DataSource dataSource) {
		this.jdbcTemplate =new JdbcTemplate(dataSource);
		
	}
	
	@Override
	public int save(Account acc) {
		String sql = "INSERT INTO Account (username, password, position, enable) VALUES(?, ?, ?, ?)";
		return jdbcTemplate.update(sql, acc.getUsername(), acc.getPassword(), acc.getPosition(), acc.getEnable());
	}

	@Override
	public int update(Account acc) {
		String sql = "UPDATE Account Set username = ?, password = ?, position = ?, enable = ? WHERE id = ?";
		return jdbcTemplate.update(sql, acc.getUsername(), acc.getPassword(), acc.getPosition(), acc.getEnable(), acc.getId());
	
	}

	@Override
	public Account get(Integer id) {
		
		String sql = "Select * from Account where id = "+id;
		
		ResultSetExtractor<Account> extractor = new  ResultSetExtractor<Account>() {

			@Override
			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String username = rs.getString("username");
					String password = rs.getString("password");
					String position = rs.getString("position");
					Boolean enable = rs.getBoolean("enable");
					return new Account(id, username, password, position, enable);
				}
				return null;
				
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "Delete from Account where id = "+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Account> list() {
		String sql = "SELECT * FROM Account";
	
		RowMapper<Account> rowMapper = new RowMapper<Account>() {
		
			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String position = rs.getString("position");
				Boolean enable = rs.getBoolean("enable");
				return new Account(id, username, password, position, enable);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Account login(String username, String password) {
		String sql = "Select * from Account where username = "+"'"+username+"'" +" and password="+"'"+password+"'";
		
		ResultSetExtractor<Account> extractor = new  ResultSetExtractor<Account>() {

			@Override
			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Integer id = rs.getInt("id");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String position = rs.getString("position");
					Boolean enable = rs.getBoolean("enable");
					return new Account(id,username, password, position, enable);
				}
				return null;
				
			}
			
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int getId(String username) {
		String sql = "Select id from Account where username = "+"'"+username+"'";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int block(Integer id) {
		String sql = "UPDATE Account Set enable = ? WHERE id = ?";
		return jdbcTemplate.update(sql, false, id);
	
	}


}
