/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.lhy.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * springbootweb入口
 *
 * @author xuhaitao
 * @version v 1.0.0
 * @since v 1.0.0 2018-08-01 10:17
 */
@RestController
public class IndexController {

    @Value("${lhy.name}")
    private String name;

    @Value("${lhy.id}")
    private String id;

    @ModelAttribute
    public void model(Model model){
        System.out.println("here is ModelAttribute");
        model.addAttribute("springBoot", "LHY");
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request){
        return "Hello " + request.getAttribute("springBoot");
    }


    public String getName() {
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
