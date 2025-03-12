package com.bookstrore.jpa.repositories;

import com.bookstrore.jpa.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublisherModelRepository extends JpaRepository<PublisherModel, UUID> {
}