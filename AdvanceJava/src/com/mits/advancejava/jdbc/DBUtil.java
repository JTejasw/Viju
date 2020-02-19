package com.mits.advancejava.jdbc;

import java.sql.*;

public class DBUtil {
	
	public Connection getConnection() throws ClassNotFoundException,SQLException {
	Class.forName(ApplicationLoader.getProperty(DBConstantsUsingFile.JDBC_DRIVER));
	Connection conn =  DriverManager.getConnection(
			ApplicationLoader.getProperty(DBConstantsUsingFile.JDBC_URL), 
			ApplicationLoader.getProperty(DBConstantsUsingFile.JDBC_USER),
			ApplicationLoader.getProperty(DBConstantsUsingFile.JDBC_PASSWORD));		
	return conn;
	
}

public void closeConnection(Connection conn,
							Statement stmt,
							ResultSet rs) throws SQLException {
	try {
		if (rs != null)
			rs.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	try {
		if (stmt != null)
			stmt.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	try {
		if (conn != null)
			conn.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
}	

}

