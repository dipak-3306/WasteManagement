package com.rcpit.management;

import java.sql.*;



import java.sql.DriverManager;

public class ConnectDb
{
	public static Connection obj=null;
	public static Connection connect()
	{
		
		try
		{
			if(obj==null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				obj=DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}

	
	
}