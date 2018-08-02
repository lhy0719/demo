/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.service;

/**
 * 用户处理服务接口
 *
 * @author xuhaitao
 * @version v 1.0.0
 * @since v 1.0.0 2018-08-02 17:16
 */
public interface IUserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

}
