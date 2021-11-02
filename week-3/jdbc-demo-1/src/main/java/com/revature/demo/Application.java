package com.revature.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.Driver;

public class Application {
	public static void main(String[] args) {
		String url = "jdbc:postgres://localhost:5432/postgres";
		String username = "postgres";
		String password = "password";
		
		Driver postgresDriver = new Driver();
		try {
			DriverManager.registerDriver(postgresDriver);
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			System.out.println(con);
			
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM students");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//int studentID = rs.getString(1);
				//String firstname = rs.getString(1);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
