package com.demosecurity.service;

import com.demosecurity.model.User;
import com.demosecurity.model.UserPrincipal;
import com.demosecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findUserByUsername(username);

        if(user == null){
            System.out.println("The user not found");
            throw new UsernameNotFoundException("User not found");
        }

        //creating new UserPrincipal with our users from the database
        return new UserPrincipal(user);
    }
}
