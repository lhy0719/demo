/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.repository;

import com.lhy.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户数据处理
 *
 * @author xuhaitao
 * @version v 1.0.0
 * @since v 1.0.0 2018-08-03 14:40
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

}
