package com.fastech.springjunittest.service;

import com.fastech.springjunittest.model.User;
import com.fastech.springjunittest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findByUserId(Long id){
        return userRepository.findById(id);
    }
}
