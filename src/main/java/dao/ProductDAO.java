package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {

	private Connection connection;
	
	public ProductDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void create(String name, Integer quantity) {
		
		String sql = "INSERT INTO product (name, quantity) VALUES (?, ?)";
		Integer generatedKey = null;
		
		try {
			
			try ( PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ) {
				
				stm.setString(1, name);
				stm.setInt(2, quantity);
				stm.execute();
				
				try ( ResultSet rs = stm.getGeneratedKeys() ) {
					while (rs.next()) {
						generatedKey = rs.getInt(1);
					}
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("[PRODUCTDAO] Create, Generated Key: " + generatedKey);
		
	}
	
	public Product retrieve(Integer id) {
		
		String sql = "SELECT * FROM product WHERE id = ?";
		Product product = null;
		
		try {
			try ( PreparedStatement stm = connection.prepareStatement(sql) ) {
				
				stm.setInt(1, id);
				stm.execute();
				
				try ( ResultSet rs = stm.getResultSet() ) {
					while (rs.next()) {
						product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3));
					}
				}
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return product;
		
	}
	
	public List<Product> retrieveAll() {
		
		String sql = "SELECT * FROM product";
		List<Product> products = new ArrayList<>();
		
		try {
			try ( PreparedStatement stm = connection.prepareStatement(sql) ) {
				
				stm.execute();
				
				try ( ResultSet rs = stm.getResultSet() ) {
					
					while(rs.next()) {
						products.add(
								new Product(rs.getInt(1), rs.getString(2), rs.getInt(3))
								);
						
					}
					
				}
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return products;
		
	}
	
	public void update(Integer id, String name, Integer quantity) {
		
		String sql = "UPDATE product SET name = ?, quantity = ? WHERE id = ?";
		Integer rowsAffected = null;
		
		try {
			
			try ( PreparedStatement stm = connection.prepareStatement(sql) ) {
				
				stm.setString(1, name);
				stm.setInt(2, quantity);
				stm.setInt(3, id);
				stm.execute();
				
				rowsAffected = stm.getUpdateCount();
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("[PRODUCTDAO] Update, rows affected: " + rowsAffected);
		
	}
	
	public void delete(Integer id) {
		
		String sql = "DELETE FROM product WHERE id = ?";
		Integer rowsAffected = null;
		
		try {
			
			try ( PreparedStatement stm = connection.prepareStatement(sql) ) {
				
				stm.setInt(1, id);
				stm.execute();
				
				rowsAffected = stm.getUpdateCount();
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("[PRODUCTDAO] Delete, rows affected: " + rowsAffected);
		
	}
	
}
