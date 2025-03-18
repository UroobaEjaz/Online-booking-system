package com.example.demo.Repository.JPA;

import com.example.demo.Repository.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<Users, Integer> {
}
