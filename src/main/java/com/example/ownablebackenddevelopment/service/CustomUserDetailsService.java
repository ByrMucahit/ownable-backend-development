package com.example.ownablebackenddevelopment.service;

import com.example.ownablebackenddevelopment.domain.User;
import com.example.ownablebackenddevelopment.domain.model.CustomUserDetails;
import com.example.ownablebackenddevelopment.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findOneByLogin(username);

        if ( user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomUserDetails(user.get());
    }
}
