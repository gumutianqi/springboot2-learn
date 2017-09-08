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
package com.weteam.springboot2case.service;

import com.weteam.springboot2case.domain.UserDomain;
import com.weteam.springboot2case.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Description: TODO
 * Created by LarryKoo (gumutianqi@gmail.com) on 2017/9/8 18:46
 * Since: 1.0.0
 */
@Service
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    public Mono<ServerResponse> handleGetUsers(ServerRequest request) {
        return ServerResponse.ok().body(userRepository.getUsers(), UserDomain.class);
    }

    public Mono<ServerResponse> handleGetUserById(ServerRequest request) {
        return userRepository.getUserById(request.pathVariable("id"))
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), UserDomain.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
