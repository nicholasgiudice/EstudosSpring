package com.nicholas.first.jpa.config;

import com.nicholas.first.jpa.entity.User;
import com.nicholas.first.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        User user = new User();

        user.setEmail("nicholas.giudice@outlook.com");
        user.setNome("Nicholas");

        userRepository.save(user);
    }
}
