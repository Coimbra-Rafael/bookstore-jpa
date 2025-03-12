package com.bookstrore.jpa.repositories;

import com.bookstrore.jpa.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorModelRepository extends JpaRepository<AuthorModel, UUID> {
}