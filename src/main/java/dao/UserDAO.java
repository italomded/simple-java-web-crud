package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	
	private Connection connection;
	
	public UserDAO(Connection connection) {
		this.connection = connection;
	}
	
	public User validate(String login, String password) {
		
		String sql = "SELECT * FROM user WHERE login = ? AND password = ?";
		User user = null;
		
		try {
			try ( PreparedStatement stm = connection.prepareStatement(sql) ) {
			
				stm.setString(1, login);
				stm.setString(2, password);
				stm.execute();
				
				try ( ResultSet rs = stm.getResultSet() ) {
					while (rs.next()) {
						user = new User(rs.getString(1), rs.getString(2));
					}
				}
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return user;
		
	}

}
