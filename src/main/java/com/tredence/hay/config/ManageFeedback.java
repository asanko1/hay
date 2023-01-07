package com.tredence.hay.config;

import com.tredence.hay.model.Feedback;

import java.math.BigInteger;
import java.sql.*;

public class ManageFeedback {
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ManageSQL ms;
    String sql;
    PreparedStatement pstmt;
    int id,id2;
    public int addFeedback(Feedback fd){
        conn=new DBConnection().getDBConnection();
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(25));
            sql = sql.replaceFirst("[?]", (fd.getRound_synthetic_key() != null ? "'" + fd.getRound_synthetic_key() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (fd.getResult() != null ? "'" + fd.getResult() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (fd.getTech_Skill_Score() != null ? "'" + fd.getTech_Skill_Score() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (fd.getComm_Score() != null ? "'" + fd.getComm_Score() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (fd.getProposed_Employment_type() != null ? "'" + fd.getProposed_Employment_type() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (fd.getProposed_Designation() != null ? "'" + fd.getProposed_Designation() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (fd.getComment() != null ? "'" + fd.getComment() + "'" : "''"));
            sql = sql.replaceFirst("[?]", (fd.getBiz_Skill_Score() != null ? "'" + fd.getBiz_Skill_Score() + "'" : "''"));
            System.out.println(sql);
            stmt = conn.createStatement();
            id = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(26));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, fd.getRound_synthetic_key());
            pstmt.executeUpdate();
            conn.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    public Feedback getFeedback(String round_synthetic_key){
        Feedback fd=new Feedback();
        conn=new DBConnection().getDBConnection();
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(28));
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, round_synthetic_key);
            rs=pstmt.executeQuery();
            while (rs.next()){
                fd.setResult(rs.getString(1));
                fd.setTech_Skill_Score(rs.getString(2));
                fd.setComm_Score(rs.getString(3));
                fd.setProposed_Employment_type(rs.getString(4));
                fd.setProposed_Designation(rs.getString(5));
                fd.setComment(rs.getString(6));
                fd.setBiz_Skill_Score(rs.getString(7));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return fd;
    }

}
