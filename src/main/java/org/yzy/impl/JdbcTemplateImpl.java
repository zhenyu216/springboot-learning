package org.yzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yzy.dao.JdbcTemplatetDao;
import org.yzy.entity.BaseInfo;
import org.yzy.service.IJdbcTemplateService;

import java.util.List;

/**
 * Created by yangzhenyu on 2019/1/16.
 */
@Service("jdbcTemplateService")
public class JdbcTemplateImpl implements IJdbcTemplateService {

    private final JdbcTemplatetDao jdbcTemplatetDao;

    @Autowired
    public JdbcTemplateImpl(JdbcTemplatetDao jdbcTemplatetDao) {
        this.jdbcTemplatetDao = jdbcTemplatetDao;
    }

    @Override
    public List<BaseInfo> findAll() {
        return jdbcTemplatetDao.findAll();
    }

    @Override
    public BaseInfo getById(String id) {
        return jdbcTemplatetDao.getById(id);
    }
}
