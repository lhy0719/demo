/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 用户对象实体
 *
 * @author xuhaitao
 * @version v 1.0.0
 * @since v 1.0.0 2018-08-01 16:54
 */
@Entity
public class User {

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private Integer age;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
