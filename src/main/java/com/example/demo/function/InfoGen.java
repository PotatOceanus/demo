package com.example.demo.function;

import com.example.demo.entity.UserInfoGen;
import com.example.demo.entity.UserInfoPush;
//import com.example.demo.service.impl.AddUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
public class InfoGen {

//    time, ISO date format - current datetime in UTC
    public static String getStringDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        String timestamp = df.format(new Date());
        return timestamp;
    }

    public UserInfoGen getUserInfoGen (UserInfoPush userInfoPush) {

        UserInfoGen userInfoGen = new UserInfoGen();

//        set username
        String username = userInfoPush.getFirstName() + userInfoPush.getLastName();
        userInfoGen.setUsername(username);

//        set tags
        String tags = userInfoPush.getTags().stream().collect(Collectors.joining(":"));
        userInfoGen.setTags(tags);

//        set status
        userInfoGen.setStatus("active");

//        seg created time and updated time
        userInfoGen.setCreated(getStringDate());
        userInfoGen.setUpdated(getStringDate());

        return userInfoGen;
    }

}
