package com.mephi.lab4;

import com.mephi.lab4.entity.Role;
import com.mephi.lab4.entity.User;
import com.mephi.lab4.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab4Application {

    public static void main(String[] args) {
//        SpringApplication.run(Lab4Application.class, args);

        var app = SpringApplication.run(Lab4Application.class, args);

        var beanUserService = app.getBean(UserService.class);

        beanUserService.addNewUser(User.builder()
                    .firstName("Oleg")
                    .lastName("Ivanov")
                    .role(Role.ADMIN)
                .build());

        beanUserService.addNewUser(User.builder()
                .firstName("Maxim")
                .lastName("Bobrov")
                .role(Role.DEVELOPER)
                .build());

        beanUserService.addNewUser(User.builder()
                .firstName("Vadim")
                .lastName("Uhov")
                .role(Role.SYSTEM_ANALYST)
                .build());

        beanUserService.addNewUser(User.builder()
                .firstName("Maria")
                .lastName("Glazkova")
                .role(Role.TESTER)
                .build());

        beanUserService.addNewUser(User.builder()
                .firstName("Eduard")
                .lastName("Tihonov")
                .role(Role.TEAM_LEAD)
                .build());

        System.out.println(beanUserService.findAllUsers());
    }

}
