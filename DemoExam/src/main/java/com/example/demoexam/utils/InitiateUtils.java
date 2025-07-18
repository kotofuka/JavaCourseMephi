package com.example.demoexam.utils;


import com.example.demoexam.entity.Country;
import com.example.demoexam.entity.User;
import com.example.demoexam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
//        !!! Main seal data
//        userService.addNewUser(User.builder()
//                        .firstName("Josef")
//                        .age(19)
//                        .country(Country.AUSTRIA)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Mao")
//                .age(22)
//                .country(Country.CHINA)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Durand")
//                .age(45)
//                .country(Country.FRANCE)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Bernard")
//                .age(75)
//                .country(Country.GERMANY)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Maria")
//                .age(12)
//                .country(Country.GREECE)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Yan")
//                .age(15)
//                .country(Country.HONG_KONG)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Mario")
//                .age(36)
//                .country(Country.ITALY)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Akane")
//                .age(34)
//                .country(Country.JAPAN)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Charlotte")
//                .age(67)
//                .country(Country.MALAYSIA)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Carlos ")
//                .age(53)
//                .country(Country.MEXICO)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Marko")
//                .age(26)
//                .country(Country.PORTUGAL)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Pavel")
//                .age(21)
//                .country(Country.RUSSIA)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Martina")
//                .age(57)
//                .country(Country.SPAIN)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Kanya ")
//                .age(63)
//                .country(Country.THAILAND)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Defne")
//                .age(85)
//                .country(Country.TURKEY)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("Arthur")
//                .age(43)
//                .country(Country.UNITED_KINGDOM)
//                .build());
//
//        userService.addNewUser(User.builder()
//                .firstName("John")
//                .age(17)
//                .country(Country.UNITED_STATES)
//                .build());


//        !!! test of "null" param of age
        userService.addNewUser(User.builder()
                .firstName("alex")
                .country(Country.UNITED_STATES)
                .build());

        userService.addNewUser(User.builder()
                .firstName("barbara")
                .age(null)
                .country(Country.UNITED_STATES)
                .build());

        userService.addNewUser(User.builder()
                .firstName("candal")
                .age(-1)
                .country(Country.UNITED_STATES)
                .build());

        userService.addNewUser(User.builder()
                .firstName("dmitrii")
                        .age(0)
                .country(Country.UNITED_STATES)
                .build());

        userService.addNewUser(User.builder()
                .firstName("Eduard")
                        .age(1)
                .country(Country.UNITED_STATES)
                .build());

        userService.addNewUser(User.builder()
                .firstName("Kevin")
                .age(2)
                .country(Country.UNITED_STATES)
                .build());

        userService.addNewUser(User.builder()
                .firstName("Zairus")
                .age(3)
                .country(Country.UNITED_STATES)
                .build());
    }
}
