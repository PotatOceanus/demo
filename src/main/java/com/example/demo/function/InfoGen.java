package com.example.demo.function;

import com.example.demo.entity.UserInfoGen;
import com.example.demo.entity.UserInfoPush;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class InfoGen {

    public static String getStringDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        String timestamp = df.format(new Date());
        return timestamp;
    }
    public static UserInfoGen getUserInfoGen (UserInfoPush userInfoPush) {
        UserInfoGen userInfoGen = new UserInfoGen();
        String username = userInfoPush.getFirstName() + userInfoPush.getLastName();
        userInfoGen.setUsername(username);
        String tags = userInfoPush.getTag().stream().collect(Collectors.joining(":"));
        userInfoGen.setTags(tags);
        userInfoGen.setStatus("active");
        userInfoGen.setCreated(getStringDate());
        userInfoGen.setUpdated(getStringDate());
        return userInfoGen;
    }

}

}
