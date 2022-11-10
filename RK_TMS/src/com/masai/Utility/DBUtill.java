package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtill {

	private static String url;
	private static String driverName;
	private static String username;
	private static String password;

	static {

		ResourceBundle rb = ResourceBundle.getBundle("dataBasPropety");

		url = rb.getString("db.url");
		driverName = rb.getString("db.drivername");
		username = rb.getString("db.username");
		password = rb.getString("db.password");

	}

	public static Connection provideConnection() {

		Connection conn = null;

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		String url = "jdbc:mysql://localhost:3306/db3";

		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return conn;
	}

}
