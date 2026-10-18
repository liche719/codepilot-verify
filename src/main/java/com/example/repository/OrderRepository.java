package com.example.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 参数化查询：SqlRiskTool 应当不再命中此处
    public List<Map<String, Object>> findByStatus(String status) {
        return jdbcTemplate.queryForList(
                "select id, status from orders where status = ?", status);
    }
}
