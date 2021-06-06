package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class NewController {

    @ResponseBody
    @RequestMapping(value = "/calculator1")
    public HashMap getNumbers1(@RequestParam (value = "max") int max,
                               @RequestParam (value = "divisor") int divisor,
                               @RequestParam (value = "limit") int limit) {
        return Calculator.nums(max, divisor, limit);
    }

    @RequestMapping(value = "/calculator2", method = RequestMethod.POST)
    public HashMap getNumbers2(@RequestBody Numbers numbers) {
        return Calculator.nums(numbers.getMax(), numbers.getDivisor(), numbers.getLimit());
    }
}