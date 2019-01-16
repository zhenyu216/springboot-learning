package org.yzy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yzy.entity.BaseInfo;

import java.util.List;

/**
 * Created by yangzhenyu on 2019/1/16.
 */
@Repository
public class JdbcTemplatetDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplatetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BaseInfo> findAll() {
        String sql = "select * from base_info";
        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(BaseInfo.class));
    }

    public BaseInfo getById(String id) {
        String sql = "select * from base_info where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(BaseInfo.class));
    }
}
