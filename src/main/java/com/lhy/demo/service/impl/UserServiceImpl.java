/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.service.impl;

import com.lhy.demo.domain.User;
import com.lhy.demo.repository.UserRepository;
import com.lhy.demo.repository.mapper.UserMapper;
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
@com.alibaba.dubbo.config.annotation.Service(
    version = "${demo.service.version}",
    application = "${dubbo.application.id}",
    protocol = "${dubbo.protocol.id}",
    registry = "${dubbo.registry.id}")
public class UserServiceImpl implements IUserService {

  private final JdbcTemplate jdbcTemplate;
  private final UserRepository userRepository;
  private UserMapper userMapper;

  @Autowired
  public UserServiceImpl(JdbcTemplate jdbcTemplate, UserRepository userRepository,
      UserMapper userMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public void create(String name, Integer age) {
    jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
  }

  @Override
  public User findByName(String name) {
//        return userRepository.findByName(name);
    return userMapper.findByName(name);
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
