package com.example.graphqlspring.modules.category.api;

import com.example.graphqlspring.modules.category.domain.entities.Category;
import com.example.graphqlspring.modules.category.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @MutationMapping()
    Category addCategory(@Argument CategoryInput category) {
        var categoryCreated = this.repository.save(new Category(category.name));
        return categoryCreated;
    }

    @QueryMapping()
    Optional<Category> categoryById(@Argument UUID id) {
        var category = this.repository.findById(id);
        return category;
    }

    record CategoryInput(String name) {}
}
