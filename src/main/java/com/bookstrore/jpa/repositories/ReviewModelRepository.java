package com.bookstrore.jpa.repositories;

import com.bookstrore.jpa.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewModelRepository extends JpaRepository<ReviewModel, UUID> {
}