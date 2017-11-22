package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

	public static void main(String[] args) throws SQLException {
		
// Step-1 -- load the drivers
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
// Step-2 -- create the connection
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		  e.printStackTrace();
		}
		
		if (connection != null) {
			System.out.println("Connection established");
		} else {
			System.out.println("Connection failed");
		}
		
	
// Step-3 -- create statement or preparedStatement
		
		Statement stmt=connection.createStatement();
		
		ResultSet resultset=stmt.executeQuery("select * from student");
		
// Insert element in database
	
		/*	PreparedStatement stmt1=connection.prepareStatement("insert into student values(?,?,?)");  
		stmt1.setInt(1,6);//1 specifies the first parameter in the query  
		stmt1.setString(2,"asd");  
		stmt1.setString(3, "sads");
		
		int i=stmt1.executeUpdate();  
		System.out.println(i); */

		
// Update element in database

	//		PreparedStatement pstmt_update=connection.prepareStatement("update student set f_name=? where stud_id=?");  
     /* PreparedStatement pstmt_update=connection.prepareStatement("update student set stud_id=? where f_name=?");  
	  
		pstmt_update.setInt(1,3);  
		pstmt_update.setString(2,"LMN");
		
		int i1=pstmt_update.executeUpdate();
		System.out.println(i1); 
		*/
	
		
// Delete element in database
	
	/*PreparedStatement stmt2=connection.prepareStatement("delete from student where stud_id=?");  
		stmt2.setInt(1,3);  
		  
		int i=stmt2.executeUpdate();  
		System.out.println(i);  
		*/
		 
		
		while(resultset.next())
		{
			
			System.out.print(resultset.getInt("stud_id") + " ");
			System.out.print(resultset.getString("f_name") + " ");
			System.out.print(resultset.getString("l_name") + " ");
			System.out.println(); 
				
		}		
} 

}
