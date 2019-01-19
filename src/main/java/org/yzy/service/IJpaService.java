package org.yzy.service;

import org.yzy.entity.BaseInfo;

import java.util.List;

/**
 * @Author: zhenyu
 * @Date: 2019/1/19 11:26
 */
public interface IJpaService {
    Integer insert(String name, int sex, int age, String memo);

    List<BaseInfo> findAll();

    void delete(String id);

    BaseInfo getById(String id);
}
