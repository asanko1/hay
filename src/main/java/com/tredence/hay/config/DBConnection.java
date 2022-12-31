package com.tredence.hay.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public Connection getDBConnection()
	{
		String connectionUrl = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=haydb;user=hay_web;password=hay_web_001";
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		Connection con = null;
		try {
        	Class.forName(driver);
        	con = DriverManager.getConnection(connectionUrl); 

        }
        // Handle any errors that may have occurred.
        catch (SQLException  e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=haydb;user=hay_web;password=hay_web_001";
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
        	Class.forName(driver);
        	Connection con = DriverManager.getConnection(connectionUrl); 
        	Statement stmt = con.createStatement();
            String SQL = "SELECT TOP 10 * FROM haydb.dbo.Hay_Skills";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException  e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
