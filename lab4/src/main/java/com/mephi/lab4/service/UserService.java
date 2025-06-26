package com.mephi.lab4.service;


import com.mephi.lab4.dto.UserServiceRequest;
import com.mephi.lab4.dto.UserServiceResponse;
import com.mephi.lab4.dto.UserDto;
import com.mephi.lab4.entity.Role;
import com.mephi.lab4.entity.User;
import com.mephi.lab4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public List<User> findAllUsersByFirstName(String firstName){
        return userRepository.findAllByFirstName(firstName);
    }

    public UserServiceResponse addNewUserByRequest(UserServiceRequest request){
        addNewUser(User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.valueOf(request.getRole()))
                .build()
        );

        return UserServiceResponse.builder()
                    .status(true)
                .build();
    }
}
