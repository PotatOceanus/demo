package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.function.InfoGen;
import com.example.demo.function.InfoGuess;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Service
public class UpdateUserServiceImpl implements UpdateUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    InfoGuess infoGuess;

    @Autowired
    UserInfoGuess userInfoGuess;

//    @Autowired
//    InfoGen infoGen;

    @Override
    public User makeUserInfoFull(UserInfoUpdate userInfoUpdate)
            throws UserNotFoundException {
        User user_to_update =
                userRepository.findById(userInfoUpdate.getUsername())
                        .orElseThrow(() -> new UserNotFoundException("User not found by this username : " + "{" + userInfoUpdate.getUsername() + "}"));
        User user = new User();

//        first name change, guess information update
        Boolean firstName_new = (user_to_update.getFirstName() != userInfoUpdate.getFirstName() && userInfoUpdate.getFirstName() != null);
        if (firstName_new) { userInfoGuess = infoGuess.getUserInfoGuess(userInfoUpdate.getFirstName()); }

        user.setUsername(user_to_update.getUsername());
        user.setPassword(userInfoUpdate.getPassword() != null ? userInfoUpdate.getPassword() : user_to_update.getPassword());
        user.setFirstName(userInfoUpdate.getFirstName() != null ? userInfoUpdate.getFirstName() : user_to_update.getFirstName());
        user.setLastName(userInfoUpdate.getLastName() != null ? userInfoUpdate.getLastName() : user_to_update.getLastName());
        user.setEmail(userInfoUpdate.getEmail() != null ? userInfoUpdate.getEmail() : user_to_update.getEmail());
        user.setContactNumber(userInfoUpdate.getContactNumber() != null ? userInfoUpdate.getContactNumber() : user_to_update.getContactNumber());
        user.setLastName(userInfoUpdate.getLastName() != null ? userInfoUpdate.getLastName() : user_to_update.getLastName());
        user.setAge(userInfoUpdate.getAge() != 0 ? userInfoUpdate.getAge() : (firstName_new)
                                                    ? userInfoGuess.getAge() : user_to_update.getAge());
        user.setGender(userInfoUpdate.getGender() != null ? userInfoUpdate.getGender() : (firstName_new)
                                                            ? userInfoGuess.getGender() : user_to_update.getGender());
        user.setNationality(userInfoUpdate.getNationality() != null ? userInfoUpdate.getNationality() : (firstName_new)
                                                                    ? userInfoGuess.getNationality() : user_to_update.getNationality());
        System.out.println(user_to_update.getTags());
        user.setTags(userInfoUpdate.getTags() != null ? userInfoUpdate.getTags() : user_to_update.getTags());
        user.setStatus("active");
        user.setCreated(user_to_update.getCreated());
        user.setUpdated(InfoGen.getStringDate());

        return user;
    }
}
