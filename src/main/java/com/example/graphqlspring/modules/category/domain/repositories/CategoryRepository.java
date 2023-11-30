package com.example.graphqlspring.modules.category.domain.repositories;

import com.example.graphqlspring.modules.category.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
