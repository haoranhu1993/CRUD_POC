package com.example.crudpoc.service;

import com.example.crudpoc.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User add(User user);
    List<User> get();
    Optional<User> get(Integer id);
    void delete(Integer id);
}
