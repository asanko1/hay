package com.tredence.hay.config;

import com.tredence.hay.model.SQL;
import com.tredence.hay.model.Skills;
import com.tredence.hay.model.Users;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageSkills {
    ArrayList<Skills> skills=new ArrayList<Skills>();
    ManageSQL ms;
    String sql;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    Skills skill;
    public ArrayList<Skills> getAllSkills()
    {
        conn=new DBConnection().getDBConnection();
        try{
            ms=new ManageSQL();
            sql=ms.getSQL(BigInteger.valueOf(13));
            stmt =conn.createStatement();
            rs= stmt.executeQuery(sql);
            while(rs.next())
            {
                skill=new Skills();
                skill.setSkill_Name(rs.getString(2));
                skill.setSkill_Type(rs.getString(3));
                skills.add(skill);
            }
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return skills;
    }
}
