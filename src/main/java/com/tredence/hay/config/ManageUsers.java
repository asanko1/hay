package com.tredence.hay.config;

import com.tredence.hay.model.Users;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class ManageUsers {
    Users user;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ManageSQL ms;
    String sql;
    ArrayList<Users> users=new ArrayList<Users>();
    public ArrayList<Users> getAllUsers(){

            conn=new DBConnection().getDBConnection();
            try{
                ms=new ManageSQL();
                sql=ms.getSQL(BigInteger.valueOf(1));
                
                stmt =conn.createStatement();
                rs= stmt.executeQuery(sql);
                while(rs.next())
                {
                    user=new Users();
                    user.setEmail(rs.getString(1));

                    users.add(user);
                }
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }

            return users;
    }

    public boolean validateLogin(Users user){
        conn=new DBConnection().getDBConnection();
        boolean login_valid=false;
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(2));
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,user.getEmail());
            pstmt.setString(2,user.getRole());
            rs= pstmt.executeQuery();

            while(rs.next())
            {
                if(rs.getInt(1)>=1)
                {
                    login_valid=true;
                }
            }
            conn.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return login_valid;
    }
    
    

}
