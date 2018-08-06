/**
 * Company Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springbootweb入口
 *
 * @author xuhaitao
 * @version v 1.0.0
 * @since v 1.0.0 2018-08-01 10:17
 */
@Controller
public class IndexController {

  @ModelAttribute
  public void init() {
    System.out.println("here is ModelAttribute");
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  @RequestMapping("/index")
  public String index() {
    return "index";
  }

  @RequestMapping("/hello")
  public String hello() {
    return "hello";
  }
}
