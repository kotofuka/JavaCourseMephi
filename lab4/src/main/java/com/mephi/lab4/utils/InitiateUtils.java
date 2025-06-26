package com.mephi.lab4.utils;

import com.mephi.lab4.entity.Role;
import com.mephi.lab4.entity.User;
import com.mephi.lab4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.addNewUser(User.builder()
                    .firstName("Oleg")
                    .lastName("Ivanov")
                    .role(Role.ADMIN)
                .build());

        userService.addNewUser(User.builder()
                .firstName("Maxim")
                .lastName("Bobrov")
                .role(Role.DEVELOPER)
                .build());

        userService.addNewUser(User.builder()
                .firstName("Vadim")
                .lastName("Uhov")
                .role(Role.SYSTEM_ANALYST)
                .build());

        userService.addNewUser(User.builder()
                .firstName("Maria")
                .lastName("Glazkova")
                .role(Role.TESTER)
                .build());

        userService.addNewUser(User.builder()
                .firstName("Eduard")
                .lastName("Tihonov")
                .role(Role.TEAM_LEAD)
                .build());
    }
}
