package com.domain.controllers;

import com.domain.models.Review;
import com.domain.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/")  // страница
    public String home(Map<String, Object> model) {
        model.put("name", "World");
        return "home";  // шаблон
    }

    @GetMapping("/about")  // страница
    public String about(Map<String, Object> model) {
        model.put("title", "about");
        return "about";  // шаблон
    }

    @GetMapping("/reviews")  // страница
    public String reviews(Map<String, Object> model) {
        Iterable<Review> reviews = reviewRepository.findAll();
        model.put("title", "Reviews");
        model.put("reviews", reviews);
        return "reviews";  // шаблон
    }

}
