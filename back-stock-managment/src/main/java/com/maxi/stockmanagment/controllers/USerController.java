package com.maxi.stockmanagment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.stockmanagment.domains.User;
import com.maxi.stockmanagment.services.implementation.UserServiceImplementation;

@RestController
@RequestMapping("/api/users")
public class USerController {

    @Autowired
    private UserServiceImplementation userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<List<User>>(this.userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<User>(this.userService.save(user), HttpStatus.CREATED);
    }
}
