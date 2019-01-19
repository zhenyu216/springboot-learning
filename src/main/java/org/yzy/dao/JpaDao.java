package org.yzy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.yzy.entity.BaseInfo;

/**
 * @Author: zhenyu
 * @Date: 2019/1/19 11:23
 */
@Repository
public interface JpaDao extends JpaRepository<BaseInfo, String> {

    @Modifying
    @Transactional
    @Query(value = "insert into base_info (id,name,sex,age,memo) values (?,?,?,?,?)", nativeQuery = true)
    public Integer insert(String id,String name, int sex, int age, String memo);

}
