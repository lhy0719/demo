/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.service.impl;

import com.lhy.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 用户处理服务
 *
 * @author xuhaitao
 * @version v 1.0.0
 * @since v 1.0.0 2018-08-02 17:17
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}
