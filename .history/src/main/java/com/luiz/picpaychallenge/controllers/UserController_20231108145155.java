package com.luiz.picpaychallenge.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.picpaychallenge.domain.user.User;

@RestController("/users")
public class UserController {
  
  @PostMapping
  public ResponseEntity<User> createUser()
}
