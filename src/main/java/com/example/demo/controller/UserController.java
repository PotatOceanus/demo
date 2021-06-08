package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserInfoPush;
import com.example.demo.service.impl.AddUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-management")
public class UserController {

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private AddUserServiceImpl addUserServiceImpl;

    @PostMapping("/add")
//    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void addUser(@RequestBody UserInfoPush userInfoPush) {

        User user = AddUserServiceImpl.getUserInfoFull(userInfoPush);
    }

}