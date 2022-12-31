package com.tredence.hay.model;

import java.math.BigInteger;

public class SQL {
    BigInteger sql_id;
    String sql;

    public SQL() {
    }

    public SQL(BigInteger sql_id, String sql) {
        this.sql_id = sql_id;
        this.sql = sql;
    }

    public BigInteger getSql_id() {
        return sql_id;
    }

    public void setSql_id(BigInteger sql_id) {
        this.sql_id = sql_id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
