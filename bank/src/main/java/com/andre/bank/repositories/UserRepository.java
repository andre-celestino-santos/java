package com.andre.bank.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andre.bank.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
