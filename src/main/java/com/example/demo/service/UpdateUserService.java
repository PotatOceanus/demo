package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserInfoUpdate;
import com.example.demo.exceptions.UserNotFoundException;

import java.util.Optional;

public interface UpdateUserService {
    public User makeUserInfoFull(UserInfoUpdate userInfoUpdate) throws UserNotFoundException;
}
