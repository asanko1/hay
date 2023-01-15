package com.tredence.hay.config;

import com.tredence.hay.model.HireRatio;
import com.tredence.hay.model.Profile;
import com.tredence.hay.model.Users;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;

public class ManageProfile {

    Profile pf;
    Connection conn;
    Statement stmt;
    ResultSet rs,rs2;
    ManageSQL ms;
    String sql;
    ArrayList<Profile> profiles=new ArrayList<Profile>();
    PreparedStatement pstmt;
    int id;
    public int addNewProfile(Profile pf)
    {
        conn=new DBConnection().getDBConnection();


            try {
                ms = new ManageSQL();
                sql = ms.getSQL(BigInteger.valueOf(3));
                sql = sql.replaceFirst("[?]", (pf.getProfile_sythetic_key() != null ? "'" + pf.getProfile_sythetic_key() + "'" : "''"));
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
                sql = sql.replaceFirst("[?]", (pf.getGender() != null ? "'" + pf.getGender() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getExemp_flg() != null ? "'" + pf.getExemp_flg() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getExemp_id() != null ? "'" + pf.getExemp_id() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getDept() != null ? "'" + pf.getDept() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getJob_id() != null ? "'" + pf.getJob_id() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (pf.getTag() != null ? "'" + pf.getTag() + "'" : "''"));

                System.out.println(sql);
                stmt = conn.createStatement();
                id = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                conn.close();

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
            pstmt.setString(4,pf.getFirst_name().toUpperCase());
            pstmt.setString(5,pf.getLast_name().toUpperCase());
            pstmt.setString(6,pf.getPrimary_phn());
            pstmt.setString(7,pf.getPrimary_email().toUpperCase());
            pstmt.setString(8,pf.getPrimary_email().toUpperCase());



            rs=pstmt.executeQuery();
            while(rs.next())
            {
                pid=rs.getInt(1);
            }
            conn.close();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

        return pid;
    }
    public ArrayList<Profile> searchProfile(String search_by, String search_val)
    {
        conn=new DBConnection().getDBConnection();
        try{

            if(search_by.equals("profile_id")){
                ms = new ManageSQL();
                sql = ms.getSQL(BigInteger.valueOf(5));
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,search_val);
            }
            else if (search_by.equals("email")){
                ms = new ManageSQL();
                sql = ms.getSQL(BigInteger.valueOf(7));
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,search_val.toUpperCase());
                pstmt.setString(2,search_val.toUpperCase());
            }
            else if (search_by.equals("phn")){
                ms = new ManageSQL();
                sql = ms.getSQL(BigInteger.valueOf(6));
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,search_val);
                pstmt.setString(2,search_val);
            }
            else if (search_by.equals("all")){
                ms = new ManageSQL();
                sql = ms.getSQL(BigInteger.valueOf(9));
                pstmt=conn.prepareStatement(sql);

            }
            else if (search_by.equals("tag")){
                ms = new ManageSQL();
                sql = ms.getSQL(BigInteger.valueOf(14));
                String v = ("%".concat(search_val.toUpperCase())).concat("%");
                System.out.println(v);
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,v);

            }
            rs=pstmt.executeQuery();
            while (rs.next()){
                pf=new Profile();
                ms = new ManageSQL();
                sql = ms.getSQL(BigInteger.valueOf(8));
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,rs.getString(1));
                rs2=pstmt.executeQuery();
                while (rs2.next()){
                    pf.setProfile_sythetic_key(rs2.getString(2));
                    pf.setFirst_name(rs2.getString(3));
                    pf.setLast_name(rs2.getString(4));
                    pf.setPrimary_phn(rs2.getString(5));
                    pf.setPrimary_email(rs2.getString(6));
                    pf.setSec_phn(rs2.getString(7));
                    pf.setSec_email(rs2.getString(8));
                    pf.setCity(rs2.getString(9));
                    pf.setCountry(rs2.getString(10));
                    pf.setSource(rs2.getString(11));
                    pf.setRef_emp_id(rs2.getString(13));
                    pf.setLast_updated(rs2.getTimestamp(14));
                    pf.setBlacklisted(rs2.getString(15));
                    pf.setVisa_status(rs2.getString(16));
                    pf.setLinkedin_url(rs2.getString(17));
                    pf.setGithub_url(rs2.getString(18));
                    pf.setStatus(rs2.getString(19));
                    pf.setLast_updated_by(rs2.getString(20));
                    pf.setGender(rs2.getString(21));
                    pf.setExemp_flg(rs2.getString(22));
                    pf.setExemp_id(rs2.getString(23));
                    pf.setDept(rs2.getString(24));
                    pf.setJob_id(rs2.getString(25));
                    pf.setTag(rs2.getString(26));

                    profiles.add(pf);
                }

            }
            conn.close();



        }catch (SQLException e){
            e.printStackTrace();
        }

        return profiles;

    }

    public HireRatio getTotalProfileCreated(String email){
        conn=new DBConnection().getDBConnection();
        HireRatio hr=new HireRatio();
        int count=0;
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(29));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,email);
            pstmt.setString(2,"1900-01-01");
            pstmt.setString(3, "4000-01-01");
            rs=pstmt.executeQuery();
            while(rs.next()){

                hr.setResult(rs.getString(1));
                hr.setCount(rs.getInt(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return hr;
    }

    public String getCandidateLinkedIn(String profile_synthetic_key){
        String linkedin=null, github=null;
        conn=new DBConnection().getDBConnection();
        try {
            ms = new ManageSQL();
            sql = ms.getSQL(BigInteger.valueOf(35));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,profile_synthetic_key);
            rs=pstmt.executeQuery();
            while(rs.next()){
                linkedin=rs.getString(1);
                github=rs.getString(2);
            }
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return linkedin+";"+github;
    }
}
