package factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private DataSource dataSource = null;
	
	public ConnectionFactory() {
		if (dataSource == null) {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			cpds.setJdbcUrl("jdbc:mysql://localhost/webcrud?useTimezone=true&setTimezone=UTC");
			cpds.setUser("root");
			cpds.setPassword("root");
			cpds.setMaxPoolSize(15);
			this.dataSource = cpds;
		}
	}
	
	public Connection getConnection() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
