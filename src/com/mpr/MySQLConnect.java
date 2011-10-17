package com.mpr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLConnect {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		
		
		
		PreparedStatement statement = con.prepareStatement("select * from players");
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()){
			System.out.println(result.getString(1) + " " + result.getString(2));
		}
		

	}

}
