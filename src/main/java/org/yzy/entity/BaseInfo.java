package org.yzy.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by yangzhenyu on 2019/1/16.
 */
@Entity(name="base_info")
public class BaseInfo {
    @Id
    @Column(nullable = false,columnDefinition = "varchar(32)")
    private String id;
    @Column(nullable = false,columnDefinition = "varchar(32)")
    private String name;
    @Column(nullable = true,columnDefinition = "int")
    private int sex;
    @Column(nullable = true,columnDefinition = "int")
    private int age;
    @Column(nullable = true,columnDefinition = "varchar(256) comment'备注'")
    private String memo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
