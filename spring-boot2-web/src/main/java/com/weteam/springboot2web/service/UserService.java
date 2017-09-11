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
package com.weteam.springboot2web.service;

import com.weteam.springboot2web.domain.UserDomain;
import com.weteam.springboot2web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: TODO
 * Created by LarryKoo (gumutianqi@gmail.com) on 2017/9/8 18:46
 * Since: 1.0.0
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDomain> getUsers() {
        return userRepository.getUsers();
    }

    public UserDomain getUserById(String id) {
        return userRepository.getUserById(id);
    }
}
