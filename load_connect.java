package test_pro;

import java.sql.*;

//import oracle.jdbc.OracleDriver;

public class load_connect
{

	public static void main(String[] args) 
	{
		String url ="jdbc:oracle:thin:@//localhost:1521/XE";
		String uname="system";
		String passwd="system";
		ResultSetMetaData rsmd = null;
		Connection con=null;
		Statement stmt =null;
		ResultSet res = null;
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
			stmt =con.createStatement();
			res = stmt.executeQuery("SELECT * FROM SK_STU");
			System.out.println("Query executed");
		} 
		catch (SQLException e)
		{
			System.out.println("Query cannot be executed");
			
		}
		try {
			rsmd = res.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i));
			}
		} 
		catch (SQLException e1)
		{
			System.out.println("unable to get matadata");
		
		}
		
		try
		{
		
			
		while(res.next()==true)
		{
			String a = res.getString("NAME");
			String b = res.getString("USN");
			int c= res.getInt("MARKS1");
			int d= res.getInt("MARKS2");
			int e= res.getInt("MARKS3");
			System.out.println(a+" "+b+" "+c+" "+d+" "+e);
		}
		}
		catch(Exception e)
		{
			System.out.println("display not possible");
		}
		
		
		

	}

	

}

	
