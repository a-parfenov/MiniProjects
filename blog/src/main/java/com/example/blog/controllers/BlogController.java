package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
//        model.addAttribute("title", "Блог");
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("post", posts);
        return "blog-main";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Контакты");
        return "contacts";
    }
}
