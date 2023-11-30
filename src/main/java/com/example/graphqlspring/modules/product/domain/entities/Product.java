package com.example.graphqlspring.modules.product.domain.entities;

import com.example.graphqlspring.modules.category.domain.entities.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    @Column(name = "category_id")
    private UUID categoryId;

    public Product(String name, BigDecimal price, UUID categoryId) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }
}
