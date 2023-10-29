package com.commenau.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			DriverManager.registerDriver(new Driver());
			String url = "jdbc:mySQL://localhost:3306/commenau";
			String username = "root";
			String password = "";
			connection = DriverManager.getConnection(url,username,password);
		}catch(SQLException exception) {
			exception.printStackTrace();
		}
		return connection;
	}
	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			if(connection!=null) {
				connection.close();
			}
			if(statement!=null) {
				statement.close();
			}
			if(resultSet!=null) {
				resultSet.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
