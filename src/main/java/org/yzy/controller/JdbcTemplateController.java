package org.yzy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yzy.entity.BaseInfo;
import org.yzy.service.IJdbcTemplateService;

import java.util.List;

/**
 * Created by yangzhenyu on 2019/1/16.
 */
@RestController
@RequestMapping("/jdbc")
public class JdbcTemplateController {
    private final IJdbcTemplateService jdbcTemplateService;

    @Autowired
    public JdbcTemplateController(IJdbcTemplateService jdbcTemplateService) {
        this.jdbcTemplateService = jdbcTemplateService;
    }

    @GetMapping("/findAll")
    public List<BaseInfo> findAll() {
        return jdbcTemplateService.findAll();
    }

    @GetMapping("/getById")
    public BaseInfo getById(String id) {
        return jdbcTemplateService.getById(id);
    }

}
