package com.example.spring.boot.learn.controller;

import com.example.spring.boot.learn.bean.dto.UserDataDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


// 返回的是页面
@Controller
public class LoginController {

    @RequestMapping(value = "goToLoginPage")
    public String toLoginPage(Model model) {
        List<String> usernames = new ArrayList<>();
        usernames.add("LiSa");
        usernames.add("Joey");
        usernames.add("Sam");
        model.addAttribute("usernames", usernames);
        model.addAttribute("pageTitle", "LoginPage");
        return "login1.html";
    }

    @GetMapping(value = "login")
    public String toLoginPage(@ModelAttribute UserDataDto user) {
        System.out.println("==========login");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "login.html";
    }

    @PostMapping(value = "loginRequest")
    public String toLoginPageRequest(@ModelAttribute UserDataDto user, Model model) {
        System.out.println("==========loginRequest");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        return "login_success.html";
    }


    // 返回的是字符串
    @ResponseBody
    public String getStr(){
        return "返回字符串";
    }



}