package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class UserInfoPush {
    @NotBlank(message = "Blank password forbidden")
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private List<String> tags;
}
