package com.example.demoexam.service;

import com.example.demoexam.dto.UserDto;
import com.example.demoexam.dto.UserServiceRequest;
import com.example.demoexam.dto.UserServiceResponse;
import com.example.demoexam.entity.Country;
import com.example.demoexam.entity.User;
import com.example.demoexam.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Validated
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

    public UserServiceResponse addNewUserByRequest(@Valid UserServiceRequest request) {
        System.out.println("Country request: " + Country.valueOf(request.getCountry()));
        addNewUser(User.builder()
                    .firstName(request.getFirstName())
                    .age(request.getAge())
                    .country(Country.valueOf(request.getCountry()))
                .build());

        return UserServiceResponse.builder()
                    .status("Пользователь успешно добавлен")
                .build();
    }

    public List<UserDto> findAllByAgeGreaterThanEqualOrderByFirstNameAsc(Integer age) {

        return userRepository
                .findByAgeGreaterThanEqualOrderByFirstNameAsc(age)
                .stream().map(UserDto::new).collect(Collectors.toList());
    }
}
