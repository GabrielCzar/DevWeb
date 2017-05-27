package com.websi.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection () {
		String DATABASE = "atv10", 
				USER = "postgres", 
				PASS = "    ";
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost/" + DATABASE, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
