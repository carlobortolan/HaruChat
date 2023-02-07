package com.example.haruchat.service;

import com.example.haruchat.entity.BasicUser;
import com.example.haruchat.entity.User;
import com.example.haruchat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<BasicUser> findAllBasicUsers() {
        return userRepository.findAllBasicUsers();
    }

    public void deleteById(int userId) {
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            System.err.println("Unable to delete User with ID: " + userId);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found", email)));
    }
}
