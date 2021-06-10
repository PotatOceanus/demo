package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserInfoPush;
import com.example.demo.entity.UserInfoUpdate;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UpdateUserService;
import com.example.demo.service.impl.AddUserServiceImpl;
import com.example.demo.service.impl.UpdateUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/user-management")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddUserServiceImpl addUserServiceImpl;

    @Autowired
    private UpdateUserServiceImpl updateUserServiceImpl;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void addUser(@RequestBody UserInfoPush userInfoPush) {
        User user = addUserServiceImpl.getUserInfoFull(userInfoPush);
        userRepository.save(user);
    }

    @GetMapping("/find/all")
    @ResponseBody
    public List<User> findUser() {

        return userRepository.findAll();
    }

    @GetMapping("/find/{userName}")
    @ResponseBody
    public ResponseEntity<User> findOneUser(@PathVariable(value = "userName") String username)
            throws UserNotFoundException {
            User user =
                    userRepository
                            .findById(username)
                            .orElseThrow(() -> new UserNotFoundException("User not found by this username : " + "{" + username + "}"));
                return ResponseEntity.ok().body(user);
    }

    @GetMapping("/delete/{userName}")
    @ResponseBody
    public Map<String, Boolean> deleteOneUser(@PathVariable(value = "userName") String username)
            throws UserNotFoundException {
        User user =
                userRepository
                        .findById(username)
                        .orElseThrow(() -> new UserNotFoundException("User not found by this username : " + "{" + username + "}"));
        userRepository.deleteById(username);
        Map<String, Boolean> response = new HashMap<>();
        response.put("{" + username + "}" + " deleted.", Boolean.TRUE);
        return response;

    }

    @PostMapping("/update")
    @ResponseBody
    public User updateUser(@RequestBody UserInfoUpdate userInfoUpdate)
            throws UserNotFoundException {
        User user_to_update =
                userRepository
                        .findById(userInfoUpdate.getUsername())
                        .orElseThrow(() -> new UserNotFoundException("User not found by this username : " + "{" + userInfoUpdate.getUsername() + "}"));
        User user = updateUserServiceImpl.makeUserInfoFull(userInfoUpdate);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("{" + user_to_update.getUsername() + "}" + " updated.", Boolean.TRUE);
//        userRepository.save(user);
        return user;
    }
}