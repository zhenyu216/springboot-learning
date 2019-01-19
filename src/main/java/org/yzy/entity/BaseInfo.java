package org.yzy.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yangzhenyu on 2019/1/16.
 */
@ApiModel
@Entity(name = "base_info")
public class BaseInfo implements Serializable {
    @Id
    @Column(nullable = false, columnDefinition = "varchar(32)")
    private String id;

    @ApiModelProperty("用户名")
    @Column(nullable = false, columnDefinition = "varchar(32)")
    private String name;

    @ApiModelProperty("性别")
    @Column(nullable = true, columnDefinition = "int")
    private int sex;

    @ApiModelProperty("年龄")
    @Column(nullable = true, columnDefinition = "int")
    private int age;

    @ApiModelProperty("备注")
    @Column(nullable = true, columnDefinition = "varchar(256) comment'备注'")
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
