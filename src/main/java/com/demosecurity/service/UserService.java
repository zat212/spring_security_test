package com.demosecurity.service;

import com.demosecurity.model.User;
import com.demosecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);

    public User register(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
