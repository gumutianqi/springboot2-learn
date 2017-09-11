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
package com.weteam.springboot2web.repository;

import com.weteam.springboot2web.domain.UserDomain;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 * Created by LarryKoo (gumutianqi@gmail.com) on 2017/9/8 18:46
 * Since: 1.0.0
 */
@Repository
public class UserRepository {

    /**
     * 模拟 DB 数据
     */
    private final List<UserDomain> users = Arrays.asList(
            UserDomain.builder()
                    .id(1L)
                    .name("LarryKoo")
                    .address("China. Chengdu.")
                    .email("larrykoo@126.com")
                    .create_at(LocalDateTime.now())
                    .build(),
            UserDomain.builder()
                    .id(2L)
                    .name("JerryLee")
                    .address("China. Shanghai.")
                    .email("jerrylee@126.com")
                    .create_at(LocalDateTime.now())
                    .build()
    );

    public UserDomain getUserById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(Long.valueOf(id)))
                .findFirst().orElse(null);
    }

    public List<UserDomain> getUsers() {
        return users;
    }
}
