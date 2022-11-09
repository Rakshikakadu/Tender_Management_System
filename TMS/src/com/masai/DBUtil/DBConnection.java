package com.masai.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection provideConn() {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/db3";

		try {
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return conn;

	}

}
