package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class UserInfoGen {

    private String username;
    private String tags;
    private String status;
    @EqualsAndHashCode.Exclude private String created;
    @EqualsAndHashCode.Exclude private String updated;
}
