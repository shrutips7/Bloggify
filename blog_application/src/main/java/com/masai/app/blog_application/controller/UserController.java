package com.masai.app.blog_application.controller;

import com.masai.app.blog_application.entity.Blog;
import com.masai.app.blog_application.entity.User;
import com.masai.app.blog_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> userInfo=userService.getAllUsers();
        return userInfo;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        User user1=userService.addUser(user);
        return user1;

    }

    @GetMapping("/blogs/{id}")
    public List<Blog> getAllBlogsOfAUser(@PathVariable("id") Integer userId){
        return userService.getAllBlogsOfAUser(userId);
    }

    @PutMapping("/user")
    public String updateStudent(@RequestBody User user){
        String user1=userService.updateStudent(user);
        return user1;

    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer userId){
        String msg=userService.deleteUser(userId);
        return msg;
    }


}
