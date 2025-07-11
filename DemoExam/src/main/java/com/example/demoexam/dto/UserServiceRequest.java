package com.example.demoexam.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserServiceRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private Integer age;
    private String country;
}
