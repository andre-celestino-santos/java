package com.andre.bank.services;

import com.andre.bank.models.User;
import com.andre.bank.repositories.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername() {
        final var user = getRandomUser();
        userRepository.save(user);
        userService.findByUsername(user.getUsername());
    }

    @Test
    public void save() {
        final var user = getRandomUser();
        userService.save(user);
        userService.findByUsername(user.getUsername());
    }

    @Test
    public void update() {
        final var newPassword = "update";
        final var user = getRandomUser();
        userService.save(user);
        userService.update(user.getUsername(), newPassword);
        final var updatedUserOpt = userRepository.findById(user.getId());
        assertThat(updatedUserOpt.isPresent()).isTrue();
        final var updatedUser = updatedUserOpt.get();
        assertThat(updatedUser.getPassword()).isEqualTo(newPassword);
    }

    private User getRandomUser() {
        final var user = new User();
        user.setUsername(getRandomString());
        user.setPassword(getRandomString());
        return user;
    }

    private String getRandomString() {
        return String.valueOf(new Random().nextInt(10));
    }

}