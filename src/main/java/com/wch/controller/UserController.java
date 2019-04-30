package com.wch.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wch.model.Student;
import com.wch.model.User;
import com.wch.service.StudentService;
import com.wch.service.UserService;

/**
 * Description:
 * 
 * @author wangchenghong
 * @since: 2019年4月29日: 上午10:04:48
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;
    
    @Resource
    private StudentService studentService;
    
    @RequestMapping("/login")
    public String login(String userName, String password, Model model){
        if(userName == null || userName == ""){
            model.addAttribute("msg", "用户名不能为空");
            return "fail";
        }
        if(password == null || password == ""){
            model.addAttribute("msg", "密码不能为空");
            return "fail";
        }
        User user = userService.findUserByuserName(userName);
        if(user == null){
            model.addAttribute("msg", "用户还未注册,请先注册再登录");
            return "fail";
        }
        
        if(userName.equals(user.getUserName()) && password.equals(user.getPassword())){
            List<Student> studentList = studentService.findAllByownUser(userName);
            model.addAttribute("ownUser", userName);
            model.addAttribute("studentList", studentList);
            return "studentList";
        }
        
        model.addAttribute("msg", "用户名或密码不正确");
        return "fail";
        
    }
    
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
    }
    
    @RequestMapping("/back")
    public String back(){
        return "redirect:index.html";
    }
    
    @RequestMapping("/registBack")
    public String registBack(){
        return "addUser";
    }
    
    @RequestMapping("/saveUser")
    public String saveUser(String userName, String password, String email, String address, Model model){
        if(userName == null || userName == ""){
            model.addAttribute("msg", "用户名不能为空");
            return "registFail";
        }
        if(password == null || password == ""){
            model.addAttribute("msg", "密码不能为空");
            return "registFail";
        }
        User user = userService.findUserByuserName(userName);
        if(user != null){
            model.addAttribute("msg", "用户已存在");
            return "registFail";
        }else{
            user = new User();
        }
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setAddress(address);
        userService.saveUser(user);
        model.addAttribute("msg", "用户注册成功");
        return "success";
    }
    
}
