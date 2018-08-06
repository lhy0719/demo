/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.repository.mapper;

import com.lhy.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author xuhaitao
 * @version v 1.0.0
 * @since v 1.0.0 2018-08-03 15:25
 */
@Repository
@Mapper
public interface UserMapper {

  @Select("SELECT * FROM USER WHERE NAME = #{name}")
  User findByName(@Param("name") String name);

  @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
  int insert(@Param("name") String name, @Param("age") Integer age);
}
