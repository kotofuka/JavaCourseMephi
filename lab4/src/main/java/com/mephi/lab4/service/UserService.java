package com.mephi.lab4.service;


import com.mephi.lab4.entity.User;
import com.mephi.lab4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAllUsers() {return userRepository.findAll();}

    public List<User> findAllUsersByFirstName(String firstName){
        return userRepository.findAllByFirstName(firstName);
    }
}
