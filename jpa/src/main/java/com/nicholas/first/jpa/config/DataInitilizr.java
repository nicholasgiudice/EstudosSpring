package com.nicholas.first.jpa.config;

import com.nicholas.first.jpa.entity.User;
import com.nicholas.first.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            createUser("Nicholas", "Nicholas.Giudice@outlook.com");
            createUser("Giovana", "giovana@outlook.com");
        }

        User user = userRepository.getOne(1L);

        System.out.println(user .getNome());
    }

    public void createUser(String name, String email) {
        User user = new User();
        user.setNome(name);
        user.setEmail(email);

        userRepository.save(user);
    }
}
