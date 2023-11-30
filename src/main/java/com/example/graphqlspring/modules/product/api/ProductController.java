package com.example.graphqlspring.modules.product.api;

import com.example.graphqlspring.modules.product.domain.entities.Product;
import com.example.graphqlspring.modules.product.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @MutationMapping()
    Product addProduct(@Argument ProductInput productInput) {
        var productCreated = this.repository.save(new Product(productInput.name, productInput.price, productInput.categoryId));
        return productCreated;
    }

    @QueryMapping()
    Iterable<Product> products() {
        var products = this.repository.findAll();
        return products;
    }

    record ProductInput(String name, BigDecimal price, UUID categoryId) {}
}
