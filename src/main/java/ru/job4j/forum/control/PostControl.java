package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.Date;

@Controller
public class PostControl {

    private final PostService postServices;

    public PostControl(PostService postServices) {
        this.postServices = postServices;
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", postServices.findById(Integer.valueOf(id)));
        return "post/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Post post) {
        postServices.   update(post);
        return "redirect:/index";
    }

    @GetMapping(value = "/create", produces = { "application/json", "application/xml" })
    public String create() {
        return "post/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        post.setCreated(new Date());
        postServices.create(post);
        return "redirect:/";
    }
}
