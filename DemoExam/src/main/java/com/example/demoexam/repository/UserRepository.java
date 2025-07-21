package com.example.demoexam.repository;

import com.example.demoexam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Получить всех пользователей, возраст которых больше или равен "age"
//    и упопорядочить с учетом регистра поля "firstName"
    List<User> findByAgeGreaterThanEqualOrderByFirstNameAsc(Integer age);
}
