package org.yzy.controller;

import com.battcn.swagger.properties.ApiDataType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yzy.entity.BaseInfo;
import org.yzy.service.IJdbcTemplateService;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by yangzhenyu on 2019/1/16.
 */
@Api(tags = "1.0",description = "用户管理",value = "用户管理")
@RestController
@RequestMapping("/jdbc")
public class JdbcTemplateController {
    private final IJdbcTemplateService jdbcTemplateService;
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    public JdbcTemplateController(IJdbcTemplateService jdbcTemplateService) {
        this.jdbcTemplateService = jdbcTemplateService;
    }

    @GetMapping("/findAll")
    public List<BaseInfo> findAll() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        List<BaseInfo> all = jdbcTemplateService.findAll();
        IntStream.range(0, all.size()).forEach(i -> {
            executorService.execute(() -> {
                redisTemplate.opsForList().leftPush("findAll", all.get(i));
            });
        });

        return all;
    }

    @ApiOperation("条件查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",dataType = ApiDataType.STRING)
    })
    @GetMapping("/getById")
    public BaseInfo getById(String id) {
        return jdbcTemplateService.getById(id);
    }


}
