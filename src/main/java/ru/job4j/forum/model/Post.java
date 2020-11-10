package ru.job4j.forum.model;

import java.util.Date;
import java.util.Objects;

public class Post {

    private int id;
    private String name;
    private String desc;
    private Date created;

    private static int incId = 0;

    public Post() {
    }

    public Post(String name, String desc) {
        this.id = incId();
        this.name = name;
        this.desc = desc;
        this.created = new Date();
    }

    private static int incId() {
        return incId++;
    }

    public static Post of(String name) {
        Post post = new Post();
        post.setName(name);
        post.setCreated(new Date());
        return post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
            Objects.equals(name, post.name) &&
            Objects.equals(desc, post.desc) &&
            Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created);
    }
}
