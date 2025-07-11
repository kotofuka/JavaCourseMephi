package com.example.demoexam.dto;


import com.example.demoexam.entity.Country;
import com.example.demoexam.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {

    private Long id;
    private String firstName;
    private Integer age;
    private Country country;

    public UserDto(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.age = user.getAge();
        this.country = user.getCountry();
    }
}
