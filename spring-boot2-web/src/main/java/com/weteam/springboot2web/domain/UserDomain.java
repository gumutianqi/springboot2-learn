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
package com.weteam.springboot2web.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description: TODO
 * Created by LarryKoo (gumutianqi@gmail.com) on 2017/9/8 18:55
 * Since: 1.0.0
 */
@Data
@Builder
public class UserDomain implements Serializable {

    private static final long serialVersionUID = -4430083610489637968L;

    private Long id;

    private String name;

    private String address;

    private String email;

    private String mobile;

    private LocalDateTime create_at;

    private LocalDateTime update_at;

    private Integer del_flag;
}
