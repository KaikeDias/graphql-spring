package com.example.graphqlspring.modules.product.domain.repositories;

import com.example.graphqlspring.modules.product.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
