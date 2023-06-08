package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entites.User;
import com.educandoweb.course.repositorys.UserRepository;

@Configuration
@Profile("teste")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {       
        User u1 = new User(null, "Érico", "erico.blp@gmail.com", "2325666", "12345");
        User u2 = new User(null, "Olivia", "olivia.blp@gmail.com", "5453656", "232332");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
    
}
