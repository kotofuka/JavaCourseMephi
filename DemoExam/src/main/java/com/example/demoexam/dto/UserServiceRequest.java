package com.example.demoexam.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @Pattern(regexp = "^[A-Z][a-z]*$",
            message = "First name must start with an uppercase letter followed by lowercase letters")
    private String firstName;

    @NotNull(message = "не должно быть нулем (принимает значения от 0 до 150)")
    @Min(0)
    @Max(150)
    private Integer age;

    private String country;
}
