package com.tredence.hay.config;

import com.tredence.hay.model.HireRatio;
import com.tredence.hay.model.Round;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;

public class ManageRounds {

    HireRatio hr;
        public ArrayList<Round> rounds = new ArrayList<Round>();
        ManageSQL ms;
        String sql;
        Round round= new Round();
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        ManagePanelist mpnl;
        ManageOrganizer mo;
        Statement stmt;
        ManageProfile mp=new ManageProfile();
        int id;

        public ArrayList<Round> getAllRoundsOfProfile(String profile_id){
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(15));
            round=new Round();
            conn=new DBConnection().getDBConnection();
            mp=new ManageProfile();
            String artifacts[]=null;
            try{
                pstmt= conn.prepareStatement(sql);
                pstmt.setString(1,profile_id);
                rs=pstmt.executeQuery();
                while (rs.next()){
                    System.out.println(rs.getString(12));
                    round=new Round();

                    round.setRound_Name(rs.getString(2));
                    round.setPanelist_id(rs.getString(3));
                    round.setOrganizer_id(rs.getString(4));
                    round.setProfile_id(rs.getString(5));
                    round.setScheduled_on(rs.getString(6));
                    round.setMode(rs.getString(7));
                    round.setIsRescheduled(rs.getString(8));
                    round.setLast_updated(rs.getDate(9));
                    round.setDuration(rs.getString(10));
                    round.setRound_type(rs.getString(11));
                    round.setRound_synthetic_key(rs.getString(12));
                    mpnl=new ManagePanelist();
                    mo=new ManageOrganizer();
                    //round.setPanelist_email(mpnl.getPanelistEmail(rs.getString(3)));
                    //round.setPanelist_name(mpnl.getPanelistName(rs.getString(3)));
                    round.setOrganizer_name(mo.getOrganizerName(rs.getString(4)));
                    artifacts=mp.getCandidateLinkedIn(profile_id).split(";");
                    round.setLinkedin(profile_id);
                    round.setLinkedin(artifacts[0]);
                    round.setGithub(artifacts[1]);
                    round.setLinkedin_panelist(mpnl.getPanelistLinkedIn(rs.getString(3)));
                    round.setStatus(rs.getString(13));
                    rounds.add(round);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
            return rounds;
        }

        public int addNewRound(Round rnd){
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(22));

            conn=new DBConnection().getDBConnection();
            try{
                sql = sql.replaceFirst("[?]", (rnd.getRound_Name() != null ? "'" + rnd.getRound_Name() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (rnd.getPanelist_id() != null ? "'" + rnd.getPanelist_id() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (rnd.getOrganizer_id() != null ? "'" + rnd.getOrganizer_id() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (rnd.getProfile_id() != null ? "'" + rnd.getProfile_id() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (rnd.getScheduled_on() != null ? "'" + rnd.getScheduled_on() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (rnd.getMode() != null ? "'" + rnd.getMode() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (rnd.getIsRescheduled() != null ? "'" + rnd.getIsRescheduled() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (rnd.getDuration() != null ? "'" + rnd.getDuration() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (rnd.getRound_type() != null ? "'" + rnd.getRound_type() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (rnd.getRound_synthetic_key() != null ? "'" + rnd.getRound_synthetic_key() + "'" : "''"));
                sql = sql.replaceFirst("[?]", (rnd.getStatus() != null ? "'" + rnd.getStatus() + "'" : "''"));
                System.out.println(sql);
                stmt = conn.createStatement();
                id = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                conn.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

                return id;
        }

    public ArrayList<Round> getAllRoundsOfPanelist(String panelist_email){
        ms=new ManageSQL();
        sql=ms.getSQL(BigInteger.valueOf(23));
        round=new Round();
        conn=new DBConnection().getDBConnection();
        try{
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,panelist_email);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println("rounds"+rs.getString(12));
                round=new Round();

                round.setRound_Name(rs.getString(2));
                round.setPanelist_id(rs.getString(3));
                round.setOrganizer_id(rs.getString(4));
                round.setProfile_id(rs.getString(5));
                round.setScheduled_on(rs.getString(6));
                round.setMode(rs.getString(7));
                round.setIsRescheduled(rs.getString(8));
                round.setLast_updated(rs.getDate(9));
                round.setDuration(rs.getString(10));
                round.setRound_type(rs.getString(11));
                round.setRound_synthetic_key(rs.getString(12));
                mpnl=new ManagePanelist();
                mo=new ManageOrganizer();
                round.setPanelist_name(mpnl.getPanelistEmail(rs.getString(3)));
                round.setOrganizer_name(mo.getOrganizerName(rs.getString(4)));
                round.setStatus(rs.getString(13));
                rounds.add(round);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return rounds;
    }

    public HireRatio getTotalInterviewScheduled(String org_syn_key){
        conn=new DBConnection().getDBConnection();

        int count=0;
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(32));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,org_syn_key);
            pstmt.setString(2,"Scheduled");
            pstmt.setString(3, "Completed");
            pstmt.setString(4,"1900-01-01");
            pstmt.setString(5, "4000-01-01");
            rs=pstmt.executeQuery();
            while(rs.next()){
                hr=new HireRatio();
                hr.setResult(rs.getString(1));
                hr.setCount(rs.getInt(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return hr;
    }

    public HireRatio getTotalScreeningTaken(String email){
        conn=new DBConnection().getDBConnection();
        int count=0;
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(31));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,email);
            pstmt.setString(2,"Completed");

            pstmt.setString(3,"1900-01-01");
            pstmt.setString(4, "4000-01-01");
            rs=pstmt.executeQuery();
            while(rs.next()){
                hr=new HireRatio();
                hr.setResult(rs.getString(1));
                hr.setCount(rs.getInt(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return hr;
    }

    public HireRatio getTotalInterviewTaken(String email){
        conn=new DBConnection().getDBConnection();
        int count=0;
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(30));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,email);
            pstmt.setString(2,"Completed");

            pstmt.setString(3,"1900-01-01");
            pstmt.setString(4, "4000-01-01");
            rs=pstmt.executeQuery();
            while(rs.next()){
                hr=new HireRatio();
                hr.setResult(rs.getString(1));
                hr.setCount(rs.getInt(2));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return hr;
    }

    public ArrayList<HireRatio> getHireRatio(String email){
        conn=new DBConnection().getDBConnection();
        ArrayList<HireRatio> hra=new ArrayList<HireRatio>();
        int count=0;
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(33));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,email);
            pstmt.setString(2,"1900-01-01");
            pstmt.setString(3, "4000-01-01");
            rs=pstmt.executeQuery();
            while(rs.next()){
                hr=new HireRatio();
                hr.setResult(rs.getString(1));
                hr.setCount(rs.getInt(2));
                hra.add(hr);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return hra;
    }

    public ArrayList<Round> getAllRecentCompletedRounds(String org_syn_key){
        ms=new ManageSQL();
        sql=ms.getSQL(BigInteger.valueOf(34));
        round=new Round();
        conn=new DBConnection().getDBConnection();
        rounds=new ArrayList<Round>();
        try{
            pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,org_syn_key);
            rs=pstmt.executeQuery();
            while (rs.next()){
                System.out.println("comp round"+rs.getString(12));
                round=new Round();

                round.setRound_Name(rs.getString(2));
                round.setPanelist_id(rs.getString(3));
                round.setOrganizer_id(rs.getString(4));
                round.setProfile_id(rs.getString(5));
                round.setScheduled_on(rs.getString(6));
                round.setMode(rs.getString(7));
                round.setIsRescheduled(rs.getString(8));
                round.setLast_updated(rs.getDate(9));
                round.setDuration(rs.getString(10));
                round.setRound_type(rs.getString(11));
                round.setRound_synthetic_key(rs.getString(12));
                mpnl=new ManagePanelist();
                mo=new ManageOrganizer();
                round.setPanelist_name(mpnl.getPanelistEmail(rs.getString(3)));
                round.setOrganizer_name(mo.getOrganizerName(rs.getString(4)));
                round.setStatus(rs.getString(13));
                rounds.add(round);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return rounds;
    }
}
