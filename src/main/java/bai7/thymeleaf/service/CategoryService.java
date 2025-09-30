package bai7.thymeleaf.service;


import bai7.thymeleaf.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Long id,Category category);
    void deleteCategory(Long id);
    List<Category> findAll();
    List<Category> findByName(String name);
    Optional<Category> findById(Long id);
    Page<Category> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Category> findAll(Pageable pageable);
}
