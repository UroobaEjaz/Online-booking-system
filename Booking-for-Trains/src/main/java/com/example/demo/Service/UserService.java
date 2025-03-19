package com.example.demo.Service;

import com.example.demo.Repository.JPA.TrainJpa;
import com.example.demo.Repository.JPA.UserJpa;
import com.example.demo.Repository.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserJpa userJpa;

    private final TrainJpa trainJpa;

    public UserService(UserJpa userJpa, TrainJpa trainJpa) {
        this.userJpa = userJpa;
        this.trainJpa = trainJpa;
    }

    public Users saveUser(Users user) {
        return userJpa.save(user);
    }

    public Optional<Users> getUserById(int userId) {
        return userJpa.findById(userId);
    }




    // Method to add user
    public Users addUser(Users newUser) {
        return userJpa.save(newUser);  // Save user to the database
    }

    public List<Users> getAllUsers() {
        return userJpa.findAll();
    }

    public void deleteUsers(int id) {
        userJpa.deleteById(id);
    }

}

