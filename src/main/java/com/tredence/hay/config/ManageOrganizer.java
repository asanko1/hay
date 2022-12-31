package com.tredence.hay.config;

import com.tredence.hay.model.Organizer;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageOrganizer {
    Organizer org;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ManageSQL ms;
    String sql;
    public Organizer getAllOrganizers()
    {
        conn=new DBConnection().getDBConnection();
        org=new Organizer();

        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(1));
            stmt =conn.createStatement();
            rs= stmt.executeQuery(sql);
            while(rs.next())
            {

            }
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return org;
    }
}
