package com.hit.buoi2.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class User {

    private String name;
    private String password;

    @Bean
    public void sleep() {
        System.out.println("Sleep....");
    }

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
