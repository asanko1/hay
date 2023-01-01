package com.tredence.hay.config;

import com.tredence.hay.model.Organizer;
import com.tredence.hay.model.Panelist;

import java.math.BigInteger;
import java.sql.*;

public class ManagePanelist {
    Panelist panelist;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ManageSQL ms;
    String sql;
    PreparedStatement pstmt;
    int id,id2;
    Panelist pnl;

    public int addNewPanelist(Panelist pnl){

        conn=new DBConnection().getDBConnection();
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(12));
            sql = sql.replaceFirst("[?]", (pnl.getPanelist_synthetic_key() != null ? "'" + pnl.getPanelist_synthetic_key() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getFirst_name() != null ? "'" + pnl.getFirst_name() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getLast_name() != null ? "'" + pnl.getLast_name() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getCity() != null ? "'" + pnl.getCity() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getCountry() != null ? "'" + pnl.getCountry() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getTimezone() != null ? "'" + pnl.getTimezone() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getEmail() != null ? "'" + pnl.getEmail() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getSkillset() != null ? "'" + pnl.getSkillset() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getDept() != null ? "'" + pnl.getDept() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getPhone() != null ? "'" + pnl.getPhone() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getLinkedin_url() != null ? "'" + pnl.getLinkedin_url() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (pnl.getLeadership_profile() != null ? "'" + pnl.getLeadership_profile() + "'" : "''"));
            System.out.println(sql);
            stmt = conn.createStatement();
            id = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            sql=ms.getSQL(BigInteger.valueOf(11));
            sql = sql.replaceFirst("[?]", (pnl.getEmail() != null ? "'" + pnl.getEmail() + "'" : "''"));
            sql = sql.replaceFirst("[?]", "'Panelist'");
            sql = sql.replaceFirst("[?]", (pnl.getLeadership_profile() != null ? "'" + pnl.getLeadership_profile() + "'" : "''"));

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

}
