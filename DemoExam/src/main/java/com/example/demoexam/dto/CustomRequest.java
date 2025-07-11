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
public class CustomRequest implements Serializable {
    // TODO: rebuild class for request in point 3 in the task
    // todo: convert "age" to parameter
    private Integer age;
}
