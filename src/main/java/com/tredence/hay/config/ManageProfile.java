package com.tredence.hay.config;

import com.tredence.hay.model.Profile;
import com.tredence.hay.model.Users;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;

public class ManageProfile {

    Profile pf;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ManageSQL ms;
    String sql;
    ArrayList<Profile> users=new ArrayList<Profile>();
    int id;
    public int addNewProfile(Profile pf)
    {
        conn=new DBConnection().getDBConnection();


            try {
                ms = new ManageSQL();
                sql = ms.getSQL(BigInteger.valueOf(3));

                sql = sql.replaceFirst("[?]", (pf.getFirst_name() != null ? "'" + pf.getFirst_name() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getLast_name() != null ? "'" + pf.getLast_name() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getPrimary_phn() != null ? "'" + pf.getPrimary_phn() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getPrimary_email() != null ? "'" + pf.getPrimary_email() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getSec_phn() != null ? "'" + pf.getSec_phn() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getSec_email() != null ? "'" + pf.getSec_email() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getCity() != null ? "'" + pf.getCity() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getCountry() != null ? "'" + pf.getCountry() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getSource() != null ? "'" + pf.getSource() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getRef_emp_id() != null ? "'" + pf.getRef_emp_id() + "'" : "''"));
                sql = sql.replaceFirst("[?]", "'N'");
                sql = sql.replaceFirst("[?]", (pf.getVisa_status() != null ? "'" + pf.getVisa_status() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getLinkedin_url() != null ? "'" + pf.getLinkedin_url() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getGithub_url() != null ? "'" + pf.getGithub_url() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getStatus() != null ? "'" + pf.getStatus() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getLast_updated_by() != null ? "'" + pf.getLast_updated_by() + "'" : "''"));

                System.out.println(sql);
                stmt = conn.createStatement();
                id = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        return id;
    }
    public int checkDuplicate(Profile pf){
        int pid=0;
        conn=new DBConnection().getDBConnection();
        try {
            ms = new ManageSQL();
            sql = ms.getSQL(BigInteger.valueOf(4));
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,pf.getFirst_name().toUpperCase());
            pstmt.setString(2,pf.getLast_name().toUpperCase());
            pstmt.setString(3,pf.getPrimary_phn());
            pstmt.setString(4,pf.getPrimary_email().toUpperCase());

            rs=pstmt.executeQuery();
            while(rs.next())
            {
                pid=rs.getInt(1);
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pid;
    }
}
