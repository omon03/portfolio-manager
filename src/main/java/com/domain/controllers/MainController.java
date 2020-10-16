package com.domain.controllers;

import com.domain.models.Review;
import com.domain.models.Role;
import com.domain.models.User;
import com.domain.repo.ReviewRepository;
import com.domain.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")  // страница
    public String home(Model model) {
        model.addAttribute("title", "Home page");
//        model.addAttribute("name", "World");
        return "home";  // шаблон
    }

    @GetMapping("/about")  // страница
    public String about(Model model) {
        model.addAttribute("title", "About");
        return "about";  // шаблон
    }

    @GetMapping("/reviews")  // страница
    public String reviews(Model model) {
        Iterable<Review> reviews = reviewRepository.findAll();  // получить все записи
        model.addAttribute("title", "Reviews");
        model.addAttribute("reviews", reviews);
        return "reviews";  // шаблон
    }

    @PostMapping("/reviews-add")
    public String reviewAdd(@RequestParam String title, @RequestParam String text, Model model) {
        model.addAttribute("title", "Review add");
        Review review = new Review(title, text);
        reviewRepository.save(review);  // новая запись в таблицу

        return "redirect:/reviews";
    }

    @GetMapping("/reviews/{id}")
    public String reviewInfo(@PathVariable(value = "id") long id, Model model) {
        Optional<Review> review = reviewRepository.findById(id);
        ArrayList<Review> result = new ArrayList<>();
        review.ifPresent(result::add);

        model.addAttribute("review", result);
        return "review-info";
    }

    @GetMapping("/reviews/{id}/update")
    public String reviewUpdate(@PathVariable(value = "id") long id, Model model) {
        Optional<Review> review = reviewRepository.findById(id);
        ArrayList<Review> result = new ArrayList<>();
        review.ifPresent(result::add);

        model.addAttribute("review", result);
        return "review-update";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String addUserRegistration(User user, Model model) {
        user.setEnabled(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
