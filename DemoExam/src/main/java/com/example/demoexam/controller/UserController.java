package com.example.demoexam.controller;


import com.example.demoexam.dto.UserDto;
import com.example.demoexam.dto.UserServiceRequest;
import com.example.demoexam.dto.UserServiceResponse;
import com.example.demoexam.service.UserService;
import jakarta.validation.ConstraintViolationException;
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
        try{
            var response = userService.addNewUserByRequest(request);
            return ResponseEntity.ok(response);
        } catch (ConstraintViolationException e){
            return ResponseEntity
                    .badRequest().body(
                        UserServiceResponse.builder()
                                    .status("error -> " + e.getMessage().replace("addNewUserByRequest.request.", System.lineSeparator()))
                                .build()
            );
        } catch (IllegalArgumentException e){
            return ResponseEntity
                    .badRequest().body(
                            UserServiceResponse.builder()
                                    .status("error -> country: " + "'" + request.getCountry() + "' не входит в enum 'Country'")
                                    .build()
                    );
        }
    }

    @GetMapping("/additional-info")
    public ResponseEntity<List<UserDto>> findAllByAgeGreaterThanEqualOrderByFirstName(@RequestParam(required = false) Integer age){
        var users = userService.findAllByAgeGreaterThanEqualOrderByFirstNameAsc(age);

        return !users.isEmpty()
                ? ResponseEntity.ok(users)
                : ResponseEntity.ofNullable(users);
    }
}
