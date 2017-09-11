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
package com.weteam.springboot2case.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import reactor.ipc.netty.http.server.HttpServer;

/**
 * Description: TODO
 * Created by LarryKoo (gumutianqi@gmail.com) on 2017/9/8 18:52
 * Since: 1.0.0
 */
@Configuration
public class HttpServerConfig {

    @Autowired
    private Environment environment;

    @Bean
    public HttpServer httpServer(RouterFunction<?> routerFunction) {
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(routerFunction);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer server = HttpServer.create("localhost", Integer.valueOf(environment.getProperty("server.port")));
        server.newHandler(adapter);
        return server;
    }
}
