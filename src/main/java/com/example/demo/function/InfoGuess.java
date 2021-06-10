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

    UserInfoGuess userInfoGuess = new UserInfoGuess();

//    public int getAge (String firstName) {
//        Age age = restTemplate.getForObject("https://api.agify.io/?name={nameE}", Age.class, firstName);
//        return age.getAge();
//    }
//
//    public String getGender (String firstName) {
//        Gender gender = restTemplate.getForObject("https://api.genderize.io?name={nameE}", Gender.class, firstName);
//        return gender.getGender();
//    }
//
//    public String getNationality (String firstName) {
//        Nationality nationality = restTemplate.getForObject("https://api.nationalize.io?name={nameE}", Nationality.class, firstName);
//        return (String) nationality.getCountry().get(0).get("country_id");
//    }

    public UserInfoGuess getUserInfoGuess (String firstName) {


        UserInfoGuess userInfoGuess = new UserInfoGuess();

//        guess age
        Age age = restTemplate.getForObject("https://api.agify.io/?name={?}", Age.class,firstName);
        userInfoGuess.setAge(age.getAge());

//        guess gender
        Gender gender = restTemplate.getForObject("https://api.genderize.io?name={name}", Gender.class, firstName);
        userInfoGuess.setGender(gender.getGender());

//        guess nationality
        Nationality nationality = restTemplate.getForObject("https://api.nationalize.io?name={name}", Nationality.class, firstName);
        if (!nationality.getCountry().isEmpty()) {
            userInfoGuess.setNationality((String)restTemplate.getForObject("https://api.nationalize.io?name={name}", Nationality.class, firstName).getCountry().get(0).get("country_id"));
        } else {
            userInfoGuess.setNationality(null);
        }

        return userInfoGuess;
    }
}
