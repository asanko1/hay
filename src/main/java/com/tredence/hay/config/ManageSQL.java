package com.tredence.hay.config;

import com.tredence.hay.model.Organizer;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageSQL {
    Organizer org;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    String sql;

    public String getSQL(BigInteger i)
    {
        conn=new DBConnection().getDBConnection();
        org=new Organizer();
        try{

            stmt =conn.createStatement();
            rs= stmt.executeQuery("Select SQL from haydb.dbo.Hay_SQL where sql_id="+i);
            while(rs.next())
            {
                sql=rs.getString(1);
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return sql;
    }
}
