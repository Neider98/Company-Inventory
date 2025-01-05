package com.company.inventory.inventory.controller;

import com.company.inventory.inventory.response.CategoryResponseRest;
import com.company.inventory.inventory.services.CategoryServiceImpl;
import com.company.inventory.inventory.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<CategoryResponseRest> searchCategories() {
        return categoryService.search();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryResponseRest> searchCategoryById(@PathVariable("id") Long id) {
        return categoryService.searchById(id);
    }

}
