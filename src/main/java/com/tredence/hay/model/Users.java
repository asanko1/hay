package com.tredence.hay.model;

import java.math.BigInteger;

public class Users {
    BigInteger userid;
    String email, role;

    public Users() {
    }

    public Users(BigInteger userid, String email, String role) {
        this.userid = userid;
        this.email = email;
        this.role = role;
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
