package dev.umang.productservicettsevening.controllers;

import dev.umang.productservicettsevening.models.Category;
import dev.umang.productservicettsevening.models.Product;
import dev.umang.productservicettsevening.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(@Qualifier("selfCategoryService") CategoryService categoryService){
        this.categoryService= categoryService;
    }

    @GetMapping("")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();

    }
    @GetMapping("/{categoryId}")
    public List<Product> getProductsInCategory(@PathVariable ("categoryId") String categoryId){
        return categoryService.getProductsInCategory(categoryId);
    }
}
