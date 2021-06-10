package com.example.demo.service.impl;

import com.example.demo.entity.User;
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

//    @Autowired
//    private UserInfoGuess userInfoGuess;

//    @Autowired
//    private UserInfoGen userInfoGen;

    @Override
    public User getUserInfoFull(UserInfoPush userInfoPush) {

        User user_gen = infoGen.getUserInfoGen(userInfoPush);
        User user_guess = infoGuess.getUserInfoGuess(userInfoPush.getFirstName());

        User user = new User(user_gen.getUsername(),
                            userInfoPush.getPassword(),
                            userInfoPush.getFirstName(),
                            userInfoPush.getLastName(),
                            userInfoPush.getEmail(),
                            userInfoPush.getContactNumber(),
                            user_guess.getAge(),
                            user_guess.getGender(),
                            user_guess.getNationality(),
                            user_gen.getTags(),
                            user_gen.getStatus(),
                            user_gen.getCreated(),
                            user_gen.getUpdated());

        return user;
    }
}
