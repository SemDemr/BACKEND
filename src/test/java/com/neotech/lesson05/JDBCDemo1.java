package com.neotech.lesson05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {

	public static String dbUserName = "user1";
	public static String dbPassword = "Neotech@123";

	// DB url format: jdbc:jdbctype://ipaddress:portnumber/db_name
	public static String dbUrl = "jdbc:mysql://147.182.216.34:3306/LibraryMgmt";

	public static void main(String[] args) throws SQLException {

		/*
		 * HostName: 147.182.216.34
		 * Port: 3306
		 * DB Name: LibraryMgmt
		 * UserName:user1
		 * Password: Neotech@123
		 */

		// Creating a Connection to the database
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		System.out.println("Database connection is successful!!!");

		// Creating a Statement
		Statement st = conn.createStatement();

		// Executing a Query
		ResultSet rs = st.executeQuery("SELECT * FROM book");
		System.out.println("--------------------");

		// Getting values from the ResultSet
		rs.next();
		String bookName1 = rs.getString("BookName");
		System.out.println(bookName1);

		// Get values using int column index
		rs.next();
		String bookName2 = rs.getString(2);
		System.out.println(bookName2);

		// Get values using getObject
		rs.next();
		String bookName3 = rs.getObject("BookName").toString();
		System.out.println(bookName3);

		System.out.println("--- Getting values using a loop ---");
		while (rs.next()) {
			String bookName = rs.getObject("BookName").toString();
			System.out.println(bookName);
		}

		// Closing the connection and other objects
		rs.close();
		st.close();
		conn.close();
	}

}
