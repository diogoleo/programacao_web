package com.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.demo.entities.User;
import com.demo.repositories.UserRepository;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(1L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(2L, "Alex Green", "alex@gmail.com", "977777777", "654321");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
