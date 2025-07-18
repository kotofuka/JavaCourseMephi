package com.example.demoexam.service;

import com.example.demoexam.dto.UserDto;
import com.example.demoexam.dto.UserServiceRequest;
import com.example.demoexam.dto.UserServiceResponse;
import com.example.demoexam.entity.Country;
import com.example.demoexam.entity.User;
import com.example.demoexam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Transactional
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public UserServiceResponse addNewUserByRequest(UserServiceRequest request) {
        // TODO::make validation of request: "age" value should be > 0 or null if don't exist
        addNewUser(User.builder()
                    .firstName(request.getFirstName())
                    .age(request.getAge())
                    .country(Country.valueOf(request.getCountry()))
                .build());

        return UserServiceResponse.builder()
                    .status(true)
                .build();
    }

//    С учетом регистра поля "firstName"
    public List<UserDto> findAllByAgeGreaterThanEqualOrderByFirstNameAsc(Integer age) {

        return userRepository
                .findByAgeGreaterThanEqualOrderByFirstNameAsc(age)
                .stream().map(UserDto::new).collect(Collectors.toList());
    }

//    Без учета регистра поля "firstName"
    public List<UserDto> findAllByAgeGreaterThanEqualOrderByFirstNameAscIgnoreCase(Integer age) {
//        без учета "age" = null
//        return userRepository
//                .findByAgeGreaterThanEqual(age)
//                .stream().sorted(
//                        (user1, user2) -> user1.getFirstName().compareToIgnoreCase(user2.getFirstName())
//                ).map(UserDto::new).collect(Collectors.toList());

//        с проверкой "age" = null?
        var users = age == null
                ? userRepository.findAllByAge(age)
                : userRepository.findByAgeGreaterThanEqual(age);
        return users
                .stream().sorted(
                        (user1, user2) -> user1.getFirstName().compareToIgnoreCase(user2.getFirstName())
                ).map(UserDto::new).collect(Collectors.toList());
    }
}
