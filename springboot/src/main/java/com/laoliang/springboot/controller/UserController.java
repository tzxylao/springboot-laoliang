package com.laoliang.springboot.controller;

import com.laoliang.springboot.common.ResultInfo;
import com.laoliang.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/all")
    public ResultInfo strategySelect() {
        return ResultInfo.ok(userService.getAll());
    }

    @RequestMapping(value = "/user/ex")
    public ResultInfo ex() {
        System.exit(1);
        return ResultInfo.ok();
    }
}