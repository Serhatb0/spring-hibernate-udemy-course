package com.biricik.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:postgresql://localhost:5432/full-stack-ecommerce";
		String user = "postgres";
		String password = "123456";
		
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
			
			System.out.println("Connection Successful");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
