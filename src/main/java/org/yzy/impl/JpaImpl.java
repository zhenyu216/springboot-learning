package org.yzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yzy.common.Common;
import org.yzy.dao.JpaDao;
import org.yzy.entity.BaseInfo;
import org.yzy.service.IJpaService;

import java.util.List;

/**
 * @Author: zhenyu
 * @Date: 2019/1/19 11:27
 */
@Service("jpaService")
public class JpaImpl implements IJpaService {
    private JpaDao jpaDao;

    @Autowired
    public JpaImpl(JpaDao jpaDao) {
        this.jpaDao = jpaDao;
    }

    public List<BaseInfo> findAll() {
        return jpaDao.findAll();
    }

    @Override
    public Integer insert(String name, int sex, int age, String memo) {
        return jpaDao.insert(Common.uuidUtil(), name, sex, age, memo);
    }
}
