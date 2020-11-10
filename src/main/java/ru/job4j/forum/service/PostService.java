package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostMem;

import java.util.List;

@Service
public class PostService {


    private final PostMem postService = PostMem.instOf();

    public List<Post> getAll() {
        return postService.getAll();
    }

    public void update(Post post) {
        postService.update(post);
    }

    public Post findById(int id) {
        return postService.findById(id);
    }

    public void create(Post post) {
        postService.save(post);
    }
}
