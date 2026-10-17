package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportService {

    public List<String> loadReport(String status) throws Exception {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "root", "root123456");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(
                "select * from report where status = '" + status + "'");
        List<String> rows = new ArrayList<>();
        while (rs.next()) {
            rows.add(rs.getString(1));
        }
        return rows;
    }
}
