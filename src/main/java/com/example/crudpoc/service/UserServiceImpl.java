package com.example.crudpoc.service;

import com.example.crudpoc.entity.User;
import com.example.crudpoc.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public User add(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> get() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> get(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void delete(Integer id) {
        if (get(id).isPresent()) {
            userRepo.delete(get(id).get());
        }
    }
}
