package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class NewController {

    @ResponseBody
    @RequestMapping(value = "/calculator2", method = RequestMethod.POST)
    public HashMap getNumbers(@RequestBody Numbers numbers) {
        return Calculator2.nums(numbers.getMax(), numbers.getDivisor(), numbers.getLimit());
    }
}