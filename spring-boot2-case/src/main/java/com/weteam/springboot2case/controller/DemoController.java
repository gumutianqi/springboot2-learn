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
package com.weteam.springboot2case.controller;

import com.weteam.springboot2case.domain.UserDomain;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Description: TODO
 * Created by LarryKoo (gumutianqi@gmail.com) on 2017/9/6 16:17
 * Since: 1.0.0
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello Spring Boot 2.0.0.M3";
    }

    @GetMapping("/user")
    public Mono<ServerResponse> handleGetUsers() {
        return WebClient.create("http://localhost:9000").get().uri("/api/user")
                .accept(MediaType.APPLICATION_JSON).exchange()
                .flatMap(resp -> ServerResponse.ok().body(resp.bodyToFlux(UserDomain.class), UserDomain.class));
    }

    @GetMapping("/user/{id}")
    public Mono<ServerResponse> handleGetUserById(@PathVariable String id) {
        return WebClient.create("http://localhost:9000").get().uri("/api/user/" + id)
                .accept(MediaType.APPLICATION_JSON).exchange()
                .flatMap(resp -> ServerResponse.ok().body(resp.bodyToMono(UserDomain.class), UserDomain.class));
    }

}
