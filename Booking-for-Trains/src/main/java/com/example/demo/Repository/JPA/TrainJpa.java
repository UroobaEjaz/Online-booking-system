package com.example.demo.Repository.JPA;

import com.example.demo.Repository.entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainJpa extends JpaRepository<Trains, Integer> {
}
