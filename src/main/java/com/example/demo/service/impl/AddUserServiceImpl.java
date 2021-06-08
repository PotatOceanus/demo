package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.UserInfoGen;
import com.example.demo.entity.UserInfoPush;
import com.example.demo.function.InfoGen;
import com.example.demo.service.AddUserService;
import org.springframework.stereotype.Service;

@Service("addUserServiceImpl")
public class AddUserServiceImpl implements AddUserService {

//    @Autowired
//    RestTemplate restTemplate;

    public AddUserServiceImpl () {
    }

//    public AddUserServiceImpl (RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
    @Override
    public User getUserInfoFull(UserInfoPush userInfoPush) {

        UserInfoGen userInfoGen = InfoGen.getUserInfoGen(userInfoPush);
        User user = new User();
        return user;
    }
}
