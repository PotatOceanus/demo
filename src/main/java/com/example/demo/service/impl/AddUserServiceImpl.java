package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.UserInfoGen;
import com.example.demo.entity.UserInfoGuess;
import com.example.demo.entity.UserInfoPush;
import com.example.demo.function.InfoGen;
import com.example.demo.function.InfoGuess;
import com.example.demo.service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserServiceImpl implements AddUserService {


    @Autowired
    private InfoGen infoGen;

    @Autowired
    private InfoGuess infoGuess;

    @Autowired
    private UserInfoGuess userInfoGuess;

    @Autowired
    private UserInfoGen userInfoGen;

    @Override
    public User getUserInfoFull(UserInfoPush userInfoPush) {

        userInfoGen = infoGen.getUserInfoGen(userInfoPush);
        userInfoGuess = infoGuess.getUserInfoGuess(userInfoPush.getFirstName());

        User user = new User(userInfoGen.getUsername(),
                            userInfoPush.getPassword(),
                            userInfoPush.getFirstName(),
                            userInfoPush.getLastName(),
                            userInfoPush.getEmail(),
                            userInfoPush.getContactNumber(),
                            userInfoGuess.getAge(),
                            userInfoGuess.getGender(),
                            userInfoGuess.getNationality(),
                            userInfoGen.getTags(),
                            userInfoGen.getStatus(),
                            userInfoGen.getCreated(),
                            userInfoGen.getUpdated());

        return user;
    }
}
