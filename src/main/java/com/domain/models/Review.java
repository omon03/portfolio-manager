package com.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long review_id;

    private String text, title;

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
