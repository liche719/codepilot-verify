package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {

    private static final String DB_PASSWORD = "SuperSecret123!";

    public ResultSet findByEmail(Connection connection, String email) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "SELECT id, email, name FROM users WHERE email = '" + email + "'";
        return statement.executeQuery(sql);
    }

    public int deleteInactive(Connection connection) throws Exception {
        Statement statement = connection.createStatement();
        return statement.executeUpdate("DELETE FROM users WHERE last_login < now() - interval '365 days'");
    }
}