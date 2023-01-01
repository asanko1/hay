package com.tredence.hay.config;

import com.tredence.hay.model.Organizer;
import com.tredence.hay.model.Panelist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManagePanelist {
    Panelist panelist;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    ManageSQL ms;
    String sql;
    PreparedStatement pstmt;
    int id,id2;

    public int addNewPanelist(Panelist pf){


        return id;
    }

}
