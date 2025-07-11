package com.example.demoexam.repository;

import com.example.demoexam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByAgeGreaterThanEqualOrderByFirstName(Integer age);
}
