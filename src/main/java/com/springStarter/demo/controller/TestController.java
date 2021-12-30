package com.springStarter.demo.controller;

import java.util.List;

import com.springStarter.demo.model.User;
import com.springStarter.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Boot Sample Crud Application";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
       return (List<User>)userRepository.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestParam("name") String name,@RequestParam("email") String email) {
       return userRepository.save(new User(name,email));
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") int id) {
       return userRepository.findById(id).get();
    }

    @PostMapping(value="/users/{id}")
    public User updateUser(@PathVariable("id") int id,@RequestParam("name") String name, @RequestParam("email") String email) {
        User user = userRepository.findById(id).get();
        user.setEmail(email);
        user.setName(name);
        User response = userRepository.save(user);
        return response;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
       userRepository.deleteById(id);
       return "User Deleted Successfully";
    }
    

}
