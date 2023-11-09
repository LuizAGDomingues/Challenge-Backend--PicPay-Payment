package com.luiz.picpaychallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.picpaychallenge.domain.user.User;
import com.luiz.picpaychallenge.dtos.UserDTO;
import com.luiz.picpaychallenge.services.UserService;

@RestController("/users")
public class UserController {
  
  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<User> createUser(UserDTO user){
    User newUser = userService.createUser(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers(){
    List<User> users = this.userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK)
  }
}
