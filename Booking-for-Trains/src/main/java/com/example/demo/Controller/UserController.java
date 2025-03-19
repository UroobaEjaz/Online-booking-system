package com.example.demo.Controller;

import com.example.demo.Repository.entity.Users;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
        @PostMapping("/signUp")
        public Users addUser(@RequestBody Users newUser){
            return userService.addUser(newUser);
        }

        @GetMapping("/viewAll")
        public List<Users> viewUsers(){
            return userService.getAllUsers();
        }

        @DeleteMapping("/delete/user{id}")
        public String deleteByUserId(@PathVariable int id){
            userService.deleteUsers(id);
            return "User deleted successfully";
        }

        //create a log In API


    @PostMapping("/logIn")
    public String logIn(@RequestBody Users users) {
        Users existingUser = userService.getUserById(users.getUserId());

        if (existingUser != null && existingUser.getPassword().equals(users.getPassword())) {
            return "Successful login";
        }

        return "Unsuccessful login";
    }




}
