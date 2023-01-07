package com.tredence.hay.config;

import com.tredence.hay.model.Organizer;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;

public class ManageOrganizer {
    Organizer org;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ManageSQL ms;
    String sql;
    PreparedStatement pstmt;
    int id,id2;
    ArrayList<Organizer> orgs;
    public ArrayList<Organizer> getAllOrganizers()
    {
        conn=new DBConnection().getDBConnection();
        org=new Organizer();
        orgs=new ArrayList<Organizer>();

        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(21));
            stmt =conn.createStatement();
            rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                org=new Organizer();
                org.setOrganizer_synthetic_key(rs.getString(1));
                org.setEmail(rs.getString(2));
                orgs.add(org);
            }
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return orgs;
    }

    public int addNewOrganizer (Organizer org){
        conn=new DBConnection().getDBConnection();
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(10));
            sql = sql.replaceFirst("[?]", (org.getOrganizer_synthetic_key() != null ? "'" + org.getOrganizer_synthetic_key() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (org.getFirst_name() != null ? "'" + org.getFirst_name() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (org.getLast_name() != null ? "'" + org.getLast_name() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (org.getCity() != null ? "'" + org.getCity() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (org.getCountry() != null ? "'" + org.getCountry() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (org.getTimezone() != null ? "'" + org.getTimezone() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (org.getEmail() != null ? "'" + org.getEmail() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (org.getDept() != null ? "'" + org.getDept() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (org.getPhone() != null ? "'" + org.getPhone() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (org.getTeams_link() != null ? "'" + org.getTeams_link() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (org.getLeadership_profile() != null ? "'" + org.getLeadership_profile() + "'" : "''"));
            System.out.println(sql);
            stmt = conn.createStatement();
            id = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            sql=ms.getSQL(BigInteger.valueOf(11));
            sql = sql.replaceFirst("[?]", (org.getEmail() != null ? "'" + org.getEmail() + "'" : "''"));
            sql = sql.replaceFirst("[?]", "'Organizer'");
            sql = sql.replaceFirst("[?]", (org.getLeadership_profile() != null ? "'" + org.getLeadership_profile() + "'" : "''"));

            stmt = conn.createStatement();
            id2 = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id2 = rs.getInt(1);
            }
            conn.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    public String getOrganizerName(String organizer_id){
        String organizer_name=null;
        conn=new DBConnection().getDBConnection();
        try {
            ms = new ManageSQL();
            sql = ms.getSQL(BigInteger.valueOf(17));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,organizer_id);
            rs=pstmt.executeQuery();
            while(rs.next()){
                organizer_name=rs.getString(1);
            }
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return organizer_name;
    }

    public String getOrganizerSyntheticKey(String email){
        String organizer_synthetic_key=null;
        conn=new DBConnection().getDBConnection();
        try {
            ms = new ManageSQL();
            sql = ms.getSQL(BigInteger.valueOf(18));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,email);
            rs=pstmt.executeQuery();
            while(rs.next()){
                organizer_synthetic_key=rs.getString(1);
            }
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return organizer_synthetic_key;
    }

    public String getTeamsLink(String org_syn_key){
        String teams_link=null;
        conn=new DBConnection().getDBConnection();
        try {
            ms = new ManageSQL();
            sql = ms.getSQL(BigInteger.valueOf(24));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,org_syn_key);
            rs=pstmt.executeQuery();
            while(rs.next()){
                teams_link=rs.getString(1);
            }
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return teams_link;
    }
}
