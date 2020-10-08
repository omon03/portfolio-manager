package com.domain.models;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long review_id;

    private String text, title;

    public Review() {
    }

    public Review(String text, String title) {
        this.text = text;
        this.title = title;
    }

    public Long getReview_id() {
        return review_id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setReview_id(Long review_id) {
        this.review_id = review_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }
}
