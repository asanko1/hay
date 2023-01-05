package com.tredence.hay.config;

import com.tredence.hay.model.Round;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    round=new Round();

                    round.setRound_Name(rs.getString(2));
                    round.setPanelist_id(rs.getString(3));
                    round.setOrganizer_id(rs.getString(4));
                    round.setProfile_id(rs.getString(5));
                    round.setScheduled_on(rs.getDate(6));
                    round.setLast_updated(rs.getDate(7));
                    round.setDuration(rs.getString(8));
                    round.setRound_type(rs.getString(9));
                    mpnl=new ManagePanelist();
                    mo=new ManageOrganizer();
                    round.setPanelist_name(mpnl.getPanelistName(rs.getString(3)));
                    round.setOrganizer_name(mo.getOrganizerName(rs.getString(4)));
                    rounds.add(round);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
            return rounds;
        }
}
