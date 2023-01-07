package com.tredence.hay.config;

import com.tredence.hay.model.Round;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;

public class ManageRounds {

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
        int id;

        public ArrayList<Round> getAllRoundsOfProfile(String profile_id){
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(15));
            round=new Round();
            conn=new DBConnection().getDBConnection();
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
                    round.setPanelist_name(mpnl.getPanelistName(rs.getString(3)));
                    round.setOrganizer_name(mo.getOrganizerName(rs.getString(4)));
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
                round.setPanelist_name(mpnl.getPanelistName(rs.getString(3)));
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
