package org.yzy.service;

import org.yzy.entity.BaseInfo;

import java.util.List;

/**
 * Created by yangzhenyu on 2019/1/16.
 */
public interface IJdbcTemplateService {
    List<BaseInfo> findAll();
    BaseInfo getById(String id);
}
