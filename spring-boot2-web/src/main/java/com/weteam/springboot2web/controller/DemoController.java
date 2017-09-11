/*
 * 四川生学教育科技有限公司
 * Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 *
 */
package com.weteam.springboot2web.controller;

import com.weteam.springboot2web.domain.UserDomain;
import com.weteam.springboot2web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: TODO
 * Created by LarryKoo (gumutianqi@gmail.com) on 2017/9/6 16:17
 * Since: 1.0.0
 */
@RestController
@RequestMapping(value = "/api")
public class DemoController {

    private final static Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello Spring Boot 2.0.0.M3";
    }

    @GetMapping("/user")
    public List<UserDomain> handleGetUsers() {
        log.info(">>> /api/users");
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public UserDomain handleGetUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

}
