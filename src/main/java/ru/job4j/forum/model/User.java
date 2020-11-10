package ru.job4j.forum.model;

import lombok.Data;

@Data
public class User {

    private String name;

    public User of(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }
}
