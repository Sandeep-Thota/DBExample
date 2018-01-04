package com.example.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) {
		
		new TestConnection().testDBConnection();

	}
	
	
	private void testDBConnection() {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //load driver
			
		Connection con =	DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=studentdb;integratedSecurity=true;");
		
		/// statemetn - static		
		
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		PreparedStatement ps=con.prepareStatement("select * from student where id=?");
		ps.setInt(0, 1);
		ResultSet rs=stmt.executeQuery("select * from student");
		
		
		while(rs.next()) {
			rs.getString("id");
			
		}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
