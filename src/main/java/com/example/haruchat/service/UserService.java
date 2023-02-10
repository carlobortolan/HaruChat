package com.example.haruchat.service;

import com.example.haruchat.entity.BasicUser;
import com.example.haruchat.entity.User;
import com.example.haruchat.exception.UniqueConstraintException;
import com.example.haruchat.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Argon2PasswordEncoder argon2PasswordEncoder;

    public User save(User user) {
        user.setPassword(argon2PasswordEncoder.encode(user.getPassword()));

        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new UniqueConstraintException(MessageFormat.format("Username '{0}' or email '{1}' is already taken!", user.getUsername(), user.getEmail()));
        }
    }

    public User findById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Could not find user with ID: {0}", userId)));
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
