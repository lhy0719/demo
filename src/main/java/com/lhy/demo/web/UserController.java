/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.web;

import com.lhy.demo.domain.User;
import com.lhy.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 用户信息处理器
 *
 * @author xuhaitao
 * @version v 1.0.0
 * @since v 1.0.0 2018-08-01 16:55
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private IUserService userService;
  //创建线程安全的map
  static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<User> getUserList() {
    // 处理"/users/"的GET请求，用来获取用户列表
    // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
    List<User> userList = new ArrayList<>(users.values());
    return userList;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String postUser(@ModelAttribute User user) {
    // 处理"/users/"的POST请求，用来创建User
    // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
    users.put(user.getId(), user);
    userService.create(user.getName(), user.getAge());
    return "success";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User getUser(@PathVariable Long id) {
    // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
    // url中的id可通过@PathVariable绑定到函数的参数中
    return users.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public String putUser(@PathVariable Long id, @ModelAttribute User user) {
    // 处理"/users/{id}"的PUT请求，用来更新User信息
    User u = users.get(id);
    u.setName(user.getName());
    u.setAge(user.getAge());
    users.put(id, u);
    return "success";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public String deleteUser(@PathVariable Long id) {
    // 处理"/users/{id}"的DELETE请求，用来删除User
    users.remove(id);
    return "success";
  }

  @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
  public User findByName(@PathVariable String name) {
    return userService.findByName(name);
  }
}
