package com.domain.repo;

import com.domain.models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    /*! Crud
    * C - create
    * r - read
    * u - update
    * d - delete
    * */
}
