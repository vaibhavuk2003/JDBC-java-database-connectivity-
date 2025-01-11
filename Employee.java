package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Employee {
	
	
	public static void CreateDB() {
		
		
		
		try {
			 String URL="jdbc:mysql://localhost:3306/";
		        String uname="root";
		        String pass="vaibhav@123";   
		        String query="create database Employee;";
		        Connection con =DriverManager.getConnection(URL,uname,pass);
		        Statement st=con.createStatement();
		         st.execute(query);
		        System.out.println("created successfully");
		        con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void CreateTable() {
		try {
			 String URL="jdbc:mysql://localhost:3306/Employee";
		        String uname="root";
		        String pass="vaibhav@123";   
		        String query="create table Info(Id int(10) primary key, Name VARCHAR(50), salary int(50));";
		        Connection con =DriverManager.getConnection(URL,uname,pass);
		        Statement st=con.createStatement();
		         st.execute(query);
		        System.out.println("table created successfully");
		        con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void InsertIntoTable(String name,int id ,int salary) {
		try {
			 String URL="jdbc:mysql://localhost:3306/Employee";
		        String uname="root";
		        String pass="vaibhav@123";   
		        String query="INSERT INTO Info(Id, Name, salary) VALUES (?, ?, ?)";
		        Connection con =DriverManager.getConnection(URL,uname,pass);
		        PreparedStatement pst = con.prepareStatement(query);
		        
		        pst.setInt(1, id);       // Set ID
		        pst.setString(2, name);  // Set Name
		        pst.setInt(3, salary);   // Set Salary
		        
		        int rowsAffected = pst.executeUpdate();
		        
		        if (rowsAffected > 0) {
		            System.out.println("Data inserted successfully.");
		        } else {
		            System.out.println("Data insertion failed.");
		        }
		        con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void ShowData() {
		
		try {
			 String URL="jdbc:mysql://localhost:3306/Employee";
		        String uname="root";
		        String pass="vaibhav@123";   
		        String query="select * from Info;";
		        Connection con =DriverManager.getConnection(URL,uname,pass);
		        Statement st=con.createStatement();
		        ResultSet rs= st.executeQuery(query);
		        while(rs.next()) {
		        	System.out.println("id"+ rs.getInt(1));
		        	System.out.println("Name"+ rs.getString(2));
		        	System.out.println("salary"+ rs.getInt(3));
		        	System.out.println();
		        }
		        System.out.println("read successfully");
		        con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void Update(int Id,String name) {
		try {
			 String URL="jdbc:mysql://localhost:3306/Employee";
		        String uname="root";
		        String pass="vaibhav@123";   
		        Connection con =DriverManager.getConnection(URL,uname,pass);
		        String query="UPDATE Info SET Name = ? WHERE Id = ? ;";
		        PreparedStatement pst=con.prepareStatement(query);
		        pst.setString(1,name); 
		        pst.setInt(2, Id);
		        pst.execute();
		        System.out.println("data updated successfully... ");
		        con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}


	public void delete(int Id) {
		
		try {
			 String URL="jdbc:mysql://localhost:3306/Employee";
		        String uname="root";
		        String pass="vaibhav@123";   
		        Connection con =DriverManager.getConnection(URL,uname,pass);
		        String query="DELETE FROM Info WHERE Id = ?;";
		        PreparedStatement pst=con.prepareStatement(query);
		        pst.setInt(1, Id);
		        pst.execute();
		        System.out.println("data Deleted  successfully... ");
		        con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
