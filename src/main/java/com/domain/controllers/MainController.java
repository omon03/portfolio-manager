package com.domain.controllers;

import com.domain.models.Review;
import com.domain.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

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
        Iterable<Review> reviews = reviewRepository.findAll();  // получить все записи
        model.put("title", "Reviews");
        model.put("reviews", reviews);
        return "reviews";  // шаблон
    }

    @PostMapping("/reviews-add")
    public String reviewAdd(@RequestParam String title, @RequestParam String text, Map<String, Object> model) {
        Review review = new Review(title, text);
        reviewRepository.save(review);  // новая запись в таблицу

        return "redirect:/reviews";
    }

    @GetMapping("/reviews/{id}")
    public String reviewInfo(@PathVariable(value = "id") long id, Map<String, Object> model) {
        Optional<Review> review = reviewRepository.findById(id);
        ArrayList<Review> result = new ArrayList<>();
        review.ifPresent(result::add);

        model.put("review", result);
        return "review-info";
    }

    @GetMapping("/reviews/{id}/update")
    public String reviewUpdate(@PathVariable(value = "id") long id, Map<String, Object> model) {
        Optional<Review> review = reviewRepository.findById(id);
        ArrayList<Review> result = new ArrayList<>();
        review.ifPresent(result::add);

        model.put("review", result);
        return "review-update";
    }
}
