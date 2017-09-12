package com.qian.web.controller;

import com.qian.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qld on 2017/9/8.
 */
@RestController
public class JsonController {

@RequestMapping("/getUser")
    public User getUser(){

        User u=new User();
        u.setName("张三");
        u.setSex("男");
        return u;
    }

}
