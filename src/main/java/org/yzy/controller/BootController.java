package org.yzy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yzy.configuration.BootConfiguration;

/**
 * Created by yangzhenyu on 2019/1/15.
 */
@RestController
@RequestMapping("/boot")
public class BootController {

    private BootConfiguration bootConfiguration;

    @Autowired
    public BootController(BootConfiguration bootConfiguration) {
        this.bootConfiguration = bootConfiguration;
    }

    @GetMapping(value = "/hello/{name}")
    public String helloWold(@PathVariable("name") String name) {
        return "hello," + name;
    }

    @GetMapping(value = "/config/{id}")
    public String getConfig(@PathVariable("id") Long id) {
        return "name:" + bootConfiguration.getName() + ";author:" + bootConfiguration.getAuthor();
    }

}
