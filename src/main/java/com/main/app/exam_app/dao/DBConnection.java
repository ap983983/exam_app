package com.main.app.exam_app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam","root","ap983983");
			System.out.println("Connection successful!!!");
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
