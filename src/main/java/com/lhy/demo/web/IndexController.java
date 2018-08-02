/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * springbootweb入口
 *
 * @author xuhaitao
 * @version v 1.0.0
 * @since v 1.0.0 2018-08-01 10:17
 */
@Controller
public class IndexController {

    @Value("${lhy.name}")
    private String name;

    @Value("${lhy.id}")
    private String id;

    @ModelAttribute
    public void init(ModelMap map){
        map.addAttribute("name",getName());
        map.addAttribute("id",getId());
        System.out.println("here is ModelAttribute");
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        return "index";
    }


    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
