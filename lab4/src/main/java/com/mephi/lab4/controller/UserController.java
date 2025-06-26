package com.mephi.lab4.controller;


import com.mephi.lab4.dto.UserServiceRequest;
import com.mephi.lab4.dto.UserServiceResponse;
import com.mephi.lab4.dto.UserDto;
import com.mephi.lab4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findAllUsers() {
        var users = userService.findAllUsers();

        return !users.isEmpty()
                ? ResponseEntity.ok(users)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<UserServiceResponse> addNewUserByRequest(@RequestBody UserServiceRequest request) {
        UserServiceResponse response = null;
        try{
            response = userService.addNewUserByRequest(request);
        } catch (IllegalArgumentException e){}
        return response == null ?
                ResponseEntity.ofNullable(UserServiceResponse.builder()
                                .status(false)
                        .build())
                : ResponseEntity.ok(response);
    }
}
