package com.wch.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wch.model.User;
import com.wch.service.UserService;

/**
 * Description:
 * 
 * @author wangchenghong
 * @since: 2019年4月29日: 下午12:13:23
 */
@RestController
public class TestController {
    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello";
    }

    @RequestMapping("/save")
    public void saveUser(String name, String word) {
        User user = new User();
        user.setUserName(name);
        user.setPassword(word);
        userService.saveUser(user);
    }

    @RequestMapping("/query")
    public String query(String userName) {
        User user = userService.findUserByuserName(userName);
        return user.getUserName() + "--" + user.getPassword();
    }
}
