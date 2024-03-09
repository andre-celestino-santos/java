package com.andre.bank.models;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void assertAllFields() {
        final var id = 1l;
        final var username = "user1";
        final var password = "blabla";
        final var user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);

        assertThat(user.getId()).isEqualTo(1l);
        assertThat(user.getUsername()).isEqualTo(username);
        assertThat(user.getPassword()).isEqualTo(password);
    }

}