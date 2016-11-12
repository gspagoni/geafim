package org.spago.gsi.geafimrest.utility;

import java.sql.*;

public class JdbcSqlServerConnection {
	
	public static Connection getConnection()
	{
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=GEAFIM";
		String user = "sa";
		String password = "Leader1";
		
		try{
	        Class.forName(driver);
	        }
	        catch(ClassNotFoundException ex)
	        {
	            throw new UnsupportedOperationException(ex.getMessage());
	        }
		
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(dbURL, user, password);
			if(conn!=null)
				return conn;
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		return conn;
	}

	public static void closeConnection(Connection conn) throws SQLException
	{
		if(conn != null)
			conn.close();
	}
}
