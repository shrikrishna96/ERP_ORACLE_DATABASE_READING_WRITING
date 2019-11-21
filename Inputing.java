package test_pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Inputing {

	public static void main(String[] args) 
	{
		String url ="jdbc:oracle:thin:@//localhost:1521/XE";
		String uname="system";
		String passwd="system";
	    PreparedStatement pstmt = null;
	    //ResultSet res = null;
		Connection con=null;
		
	
		try {
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("driver loading  successful");
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("driver loading not successful");
		}
		try {
			 con = DriverManager.getConnection(url,uname, passwd);
			System.out.println("connection established");
		    } 
		catch (SQLException e)
		{
			System.out.println("connection not established");
		}  
		try 
		{
			pstmt =con.prepareStatement("INSERT INTO SK_STU VALUES(?,?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the PART_NUMBER");
			String part_number = sc.next();
			System.out.println("enter the COMPANY_NAME ");
			String company_name = sc.next();
			System.out.println("enter the DIMENSIONS ");
			String dimension = sc.next();
			System.out.println("enter the COMPONENT_NAME");
			String component_name = sc.next();
			System.out.println("enter the DATE_STARTED_PRODUCTION");
			String date_started_production = sc.next();
			System.out.println("enter the DETAILS");
			String detail = sc.next();
			pstmt.setString(1, part_number);
			pstmt.setString(2, company_name);
			pstmt.setString(3, dimension);
			pstmt.setString(4, component_name);
			pstmt.setString(5, date_started_production);
			
		    pstmt.executeQuery();
			System.out.println("Query executed");
		} 
		catch (SQLException e)
		{
			System.out.println("Query cannot be executed");
			
		}
		
	
	

	}

}
