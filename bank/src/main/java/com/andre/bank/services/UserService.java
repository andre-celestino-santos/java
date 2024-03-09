package com.andre.bank.services;

import com.andre.bank.models.User;
import com.andre.bank.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("username " + username + " not found"));
    }

    @Transactional
    public void save(User user) {
        user.setId(null);
        userRepository.save(user);
    }

    @Transactional
    public void update(String username, String password) {
        final var user = findByUsername(username);
        user.setPassword(password);
        userRepository.save(user);
    }

}