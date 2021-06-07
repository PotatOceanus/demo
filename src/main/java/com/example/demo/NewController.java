package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class NewController {

    @Autowired
    private UserRepository userRepository;
//    @ResponseBody
//    @RequestMapping(value = "/calculator1")
//    public HashMap getNumbers1(@RequestParam (value = "max") int max,
//                               @RequestParam (value = "divisor") int divisor,
//                               @RequestParam (value = "limit") int limit) {
//        return Calculator.nums(max, divisor, limit);
//    }
//
//    @RequestMapping(value = "/calculator2", method = RequestMethod.POST)
//    public HashMap getNumbers2(@RequestBody Numbers numbers) {
//        return Calculator.nums(numbers.getMax(), numbers.getDivisor(), numbers.getLimit());
//    }

    @RequestMapping(value ="/user-management/add", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "201 created";
    }

}