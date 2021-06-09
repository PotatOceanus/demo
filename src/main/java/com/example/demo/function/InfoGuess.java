package com.example.demo.function;

import com.example.demo.entity.UserInfoGen;
import com.example.demo.entity.UserInfoGuess;
import com.example.demo.entity.UserInfoPush;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InfoGuess {

    @Autowired
    RestTemplate restTemplate;

    public UserInfoGuess getUserInfoGuess (UserInfoPush userInfoPush) {

        UserInfoGuess userInfoGuess = new UserInfoGuess();
//        RestTemplate restTemplate = new RestTemplate();

//        guess age
        Age age = restTemplate.getForObject("https://api.agify.io/?name={nameE}", Age.class, userInfoPush.getFirstName());
        userInfoGuess.setAge(age.getAge());

//        guess gender
        Gender gender = restTemplate.getForObject("https://api.genderize.io?name={nameE}", Gender.class, userInfoPush.getFirstName());
        userInfoGuess.setGender(gender.getGender());

//        guess nationality
        Nationality nationality = restTemplate.getForObject("https://api.nationalize.io?name={nameE}", Nationality.class, userInfoPush.getFirstName());
        if (!nationality.getCountry().isEmpty()) {
            userInfoGuess.setNationality((String)restTemplate.getForObject("https://api.nationalize.io?name={nameE}", Nationality.class, userInfoPush.getFirstName()).getCountry().get(0).get("country_id"));
        } else {
            userInfoGuess.setNationality(null);
        }

        return userInfoGuess;
    }
}
