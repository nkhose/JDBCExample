package com.jdbc.demo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class JDBCtry2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			DAO();
	}

	
	 // JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/db";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    
	private static void DAO() {
		
		Connection conn = null;
		Statement stmt = null;
	      try{
	         // Register JDBC driver
	         Class.forName("com.mysql.jdbc.Driver");

	         // Open a connection
	         conn = DriverManager.getConnection(DB_URL, USER, PASS);

	         // Execute SQL query
	         stmt = conn.createStatement();
	/*         
	         // insert
             String sql = "INSERT INTO student (stud_id,f_name,l_name) VALUES (?, ?, ?)";
	         PreparedStatement pstatement = conn.prepareStatement(sql);
	         pstatement.setInt(1, 103);
	         pstatement.setString(3, "Priyanka");
	         pstatement.setString(2, "Khose");  
	         boolean rowInserted = pstatement.executeUpdate() > 0;
	         System.out.println("query executed: "+ rowInserted );
	        
	        
  	       // delete
	         sql = "DELETE FROM student where stud_id = ?";
	         pstatement.setInt(1, 103);
	         rowInserted = pstatement.executeUpdate() > 0;
	         System.out.println("query executed: "+ rowInserted );
	         
	        
	         // update
	        String sql = " UPDATE student SET "
	                 + " f_name = '" + "Pritam" + "', " + " l_name = '" + "Khose" + "' where  stud_id = 102";
	         PreparedStatement pstatement = conn.prepareStatement(sql);
	         pstatement = conn.prepareStatement(sql);
	         boolean rowInserted = pstatement.executeUpdate() > 0;
	         rowInserted = pstatement.executeUpdate() > 0;
	         System.out.println("query executed: "+ rowInserted );
	         
	  */       
	        
	         // read
	        String sql = "SELECT stud_id,f_name,l_name from student";
	         ResultSet rs = stmt.executeQuery(sql);

	         // Extract data from result set
	         while(rs.next()){
	            //Retrieve by column name
	            int id  = rs.getInt("stud_id");
	            String first = rs.getString("f_name");
	            String last = rs.getString("l_name");
	            
	            Student s =new Student(id,first,last);
	            s.setF_name(first);
	            s.setL_name(last);
	            s.setStud_id(id);
	            
	            System.out.println(s.toString());
	            //Display values
	           // System.out.println("ID: " + id + ", First: " + first + ", Last: " + last );
	         }
	        
			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}

}
