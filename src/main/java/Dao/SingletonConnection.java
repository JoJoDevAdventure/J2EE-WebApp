package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class SingletonConnection {
private static Connection connection;
	
	private SingletonConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/catalogue", "root", "YByb052002");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getInstance()
	{
		if(connection==null)
			new SingletonConnection();
		
		return connection;
	}

}
