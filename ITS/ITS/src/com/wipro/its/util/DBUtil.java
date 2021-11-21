package com.wipro.its.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getDBConnection(String driverType)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String cmd = "jdbc:oracle:thin:@localhost:1521:orcl";
			Connection con = DriverManager.getConnection(cmd, "its", "its");
			return con;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}