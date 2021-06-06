package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculator {

    static HashMap nums (int max, int divisor, int limit) {

        List<String> numbers = new ArrayList<>();
        HashMap<String, List> result = new HashMap<>();
        int start = max - max % divisor + 2;
        for (int i = 0; i < limit; i++) {
            numbers.add("I am " + String.valueOf(start - divisor * i));
        }
        result.put("data", numbers);
        return result;
    }
}
