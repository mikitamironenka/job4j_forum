package ru.job4j.forum.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private Date created;

    public Post() {
    }

    public Post(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = new Date();
    }
}
