package org.yzy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Cacheable(value = "user", key = "#id")
    public BaseInfo getById(String id) {
        System.err.println("进入get方法");
        return jpaDao.findById(id).get();
    }

    @CacheEvict(value = "user", key = "#id")
    public void delete(String id) {
        jpaDao.deleteById(id);
    }

    @Override
    public Integer insert(String name, int sex, int age, String memo) {
        return jpaDao.insert(Common.uuidUtil(), name, sex, age, memo);
    }
}
