package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

@Controller
public class UserController {

    //    static List littleFunction (int max, int divisor, int limit) {
    static List littleFunction (int max, int divisor, int limit) {
        List<String> numbers = new ArrayList<>();
//        String[] numbers = new String[limit];
        int start = max - max % divisor + 2;
        for (int i = 0; i < limit; i++) {
            numbers.add("I am " + String.valueOf(start - divisor * i));
        }
//        for (int i = 0; i < limit; i++) {
//            numbers[i] = "\"I am " + String.valueOf(start - divisor * i + "\"");
//        }
        return numbers;
    }
    @ResponseBody
    @GetMapping("/user")
    public List getUser(){
        return UserController.littleFunction(1000,7,3);
    }

    //        System.out.println(littleFunction(max,divisor,limit));
    //        System.out.println(Arrays.toString(littleFunction(max,divisor,limit)));
}