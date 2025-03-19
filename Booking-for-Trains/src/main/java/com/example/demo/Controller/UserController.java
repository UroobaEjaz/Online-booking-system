package com.example.demo.Controller;

import com.example.demo.Repository.entity.Users;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
        @PostMapping("/addUser")
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






}
