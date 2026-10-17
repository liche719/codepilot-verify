package com.example.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {

    private static final String GITHUB_TOKEN = "ghp_16abcdefghijklmnopqrstuvwxyz012345";

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findByStatus(String status) {
        String sql = "select * from orders where status = '" + status + "'";
        return jdbcTemplate.queryForList(sql);
    }
}
