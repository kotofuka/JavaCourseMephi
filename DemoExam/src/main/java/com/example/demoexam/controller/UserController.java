package com.example.demoexam.controller;


import com.example.demoexam.dto.CustomRequest;
import com.example.demoexam.dto.UserDto;
import com.example.demoexam.dto.UserServiceRequest;
import com.example.demoexam.dto.UserServiceResponse;
import com.example.demoexam.service.UserService;
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
    public ResponseEntity<List<UserDto>> findAllUsers(){
        var users = userService.findAllUsers();

        return !users.isEmpty()
                ? ResponseEntity.ok(users)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<UserServiceResponse> addNewUserByRequest(@RequestBody UserServiceRequest request){
        UserServiceResponse response = null;
        try{
            response = userService.addNewUserByRequest(request);
        } catch (IllegalArgumentException e){}

        return response == null
                ? ResponseEntity
                    .badRequest().body(
                        UserServiceResponse.builder()
                                    .status(false)
                                .build()
                    )
                : ResponseEntity.ok(response);
    }

    @GetMapping("/additional-info")
    public ResponseEntity<List<UserDto>> findAllByAgeGreaterThanEqualOrderByFirstName(@RequestParam int age){
        var users = userService.findAllUsersByAgeGreaterThanEqualOrderByFirstName(age);

        return !users.isEmpty()
                ? ResponseEntity.ok(users)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
