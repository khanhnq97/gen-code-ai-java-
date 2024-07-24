package com.example.gen_code_ai.controller;

import com.example.gen_code_ai.entity.User;
import com.example.gen_code_ai.request.UserRequest;
import com.example.gen_code_ai.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired private UserService userService;

  @PostMapping
  public User createUser(@RequestBody UserRequest request) {
    return userService.createUser(request);
  }

  @GetMapping
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable String id) {
    return userService.getUserById(id);
  }

  @PutMapping("/{id}")
  public User updateUser(@PathVariable String id, @RequestBody UserRequest request) {
    return userService.updateUser(id, request);
  }

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable String id) {
    userService.deleteUser(id);
    return "User deleted successfully";
  }
}
