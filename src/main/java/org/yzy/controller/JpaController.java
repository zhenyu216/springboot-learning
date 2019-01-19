package org.yzy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yzy.entity.BaseInfo;
import org.yzy.service.IJpaService;

import java.util.List;

/**
 * @Author: zhenyu
 * @Date: 2019/1/19 11:31
 */
@RestController
@RequestMapping("/jpa")
public class JpaController {
    private IJpaService jpaService;

    @Autowired
    public JpaController(IJpaService jpaService) {
        this.jpaService = jpaService;
    }

    @GetMapping("/insert")
    public int insert() {

        return jpaService.insert("yangzhenyu", 1, 23, "jpa learning");
    }

    @GetMapping("/findAll")
    public List<BaseInfo> findAll() {
        return jpaService.findAll();
    }


    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id) {
        jpaService.delete(id);
    }

    @GetMapping("/getById/{id}")
    public BaseInfo getById(@PathVariable("id") String id) {
        return jpaService.getById(id);
    }
}
