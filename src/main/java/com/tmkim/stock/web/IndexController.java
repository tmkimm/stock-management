package com.tmkim.stock.web;

import com.tmkim.stock.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class IndexController {
    private final PostsService postsService;
    @GetMapping("/")
    public ModelAndView index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

}
