package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorMDL {

    static List getNumbers (int max, int divisor, int limit) {
        List<String> numbers = new ArrayList<>();
        int start = max - max % divisor + 2;
        for (int i = 0; i < limit; i++) {
            numbers.add("I am " + String.valueOf(start - divisor * i));
        }
        return numbers;
    }

    @ResponseBody
    @GetMapping("CalculatorMDL")
    public List getData(@RequestParam(value = "Max") int max,
                        @RequestParam(value = "Divisor") int divisor,
                        @RequestParam(value = "Limit") int limit) {
        return getNumbers(max, divisor, limit);
    }
}
