package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public PostService(PostRepository postService, UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.postRepository = postService;
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        postRepository.findAll().forEach(rsl :: add);
        return rsl;
    }

    public void update(Post post) {
        Optional<Post> optinalPost = postRepository.findById(post.getId());
        if (optinalPost.isPresent()){
            Post postTemp = optinalPost.get();
            if (post.getName() != null)
                postTemp.setName(post.getName());
            if (post.getDescription() != null)
                postTemp.setDescription(post.getDescription());
            this.postRepository.save(postTemp);
        }
    }

    public Post findById(int id) {
        return postRepository.findById(id).orElseThrow();
    }

    public void create(Post post) {
        postRepository.save(post);
    }

    public Authority findByAuthority(String authoriry) {
        return authorityRepository.findByAuthority(authoriry);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
