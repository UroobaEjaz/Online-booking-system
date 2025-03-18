package com.example.demo.Service;

import com.example.demo.Repository.JPA.UserJpa;
import com.example.demo.Repository.entity.Trains;
import com.example.demo.Repository.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {


    private final UserJpa userJpa;

    public UserService(UserJpa userJpa) {
        this.userJpa = userJpa;
    }

    public Users saveUser(Users user) {
        return userJpa.save(user);
    }

    public Users getUserById(int userId) {
        return userJpa.findById(userId).orElse(null);
    }


    // Method to add user
    public Users addUser(Users newUser) {
        return userJpa.save(newUser);  // Save user to the database
    }

    public List <Users> getAllUsers(){
        return userJpa.findAll();
    }
}
