package ru.job4j.forum.repository;

import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostMem {

    private static PostMem POST_MEM = new PostMem();
    private final HashMap<Integer, Post> posts = new HashMap<>();
    private static int incId = 0;

    private PostMem() {
//        posts.put(incId(), Post.of("Продаю машину ладу 01."));
//        posts.put(incId(), Post.of("Продаю машину ладу 02."));
//        posts.put(incId(), Post.of("Продаю машину ладу 03."));
    }

    public List<Post> getAll() {
        return new ArrayList<>(posts.values());
    }

    public Post findById(int id) {
        return posts.get(id);
    }


    private static int incId() {
        return incId++;
    }

    public static PostMem instOf() {
        return POST_MEM;
    }

    public void save(Post post) {
        post.setId(incId());
        posts.put(post.getId(), post);
    }

    public void update(Post post) {
        findById(post.getId()).setName(post.getName());
        findById(post.getId()).setDescription(post.getDescription());
    }
}
