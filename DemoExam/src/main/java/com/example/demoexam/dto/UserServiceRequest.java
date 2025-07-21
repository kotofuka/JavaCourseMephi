package com.example.demoexam.dto;


import jakarta.validation.constraints.*;
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
            message = "должно начинаться с заглавной буквы английской, за которой должны следовать строчные буквы")
    @NotBlank(message = "должно начинаться с заглавной буквы английской, за которой должны следовать строчные буквы")
    private String firstName;

    @NotNull(message = "не должно быть 'null' (принимает значения от 0 до 150)")
    @Min(0)
    @Max(150)
    private Integer age;

    @NotEmpty(message = "должно принимать значение из списка: 'AUSTRIA', " +
            "'CHINA', 'FRANCE', 'GERMANY', 'GREECE', 'HONG_KONG', 'ITALY', 'JAPAN', " +
            "'MALAYSIA', 'MEXICO', 'PORTUGAL', 'RUSSIA', 'SPAIN', 'THAILAND', 'TURKEY', 'UNITED_KINGDOM', " +
            "'UNITED_STATES'")
    private String country;
}
