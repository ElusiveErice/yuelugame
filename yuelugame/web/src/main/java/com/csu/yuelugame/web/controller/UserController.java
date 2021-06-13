package com.csu.yuelugame.web.controller;


import com.csu.yuelugame.biz.UserService;
import com.csu.yuelugame.dao.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public boolean login(@RequestBody User user){
        return userService.login(user);
    }
}
