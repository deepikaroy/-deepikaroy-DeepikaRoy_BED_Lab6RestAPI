package com.greatlearning.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.students.config.MyUserDetails;
import com.greatlearning.students.entity.User;
import com.greatlearning.students.repository.UserRepository;

import lombok.RequiredArgsConstructor;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        User user = this.userRepository.findByUsername(username);        		
        
        System.out.println("User from the repository ");
        System.out.println(user);
        
        return new MyUserDetails(user);
    }
}
