package com.example.crudpoc.controller;

import com.example.crudpoc.entity.User;
import com.example.crudpoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> list = userService.get();
            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        Optional<User> customer = userService.get(id);

        if (customer.isPresent()) {
            return new ResponseEntity<User>(customer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User customer) {
        try {
            return new ResponseEntity<User>(userService.add(customer), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User customer) {
        try {
            return new ResponseEntity<User>(userService.add(customer), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
