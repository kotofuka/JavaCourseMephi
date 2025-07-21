package com.example.demoexam.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Z][a-z]*$",
            message = "должно начинаться с заглавной буквы английской, за которой должны следовать строчные буквы")
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "country", nullable = false)
    private Country country;
}
