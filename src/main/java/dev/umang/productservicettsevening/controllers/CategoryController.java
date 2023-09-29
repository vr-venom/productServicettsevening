package dev.umang.productservicettsevening.controllers;

import dev.umang.productservicettsevening.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService= categoryService;
    }
    @GetMapping("")
    public String getAllCategories(){
        return "Gettimg all Category";
    }
    @GetMapping("/{categoryId}")
    public String getProductsInCategory(@PathVariable ("categoryId") Long categoryId){
        return "Get product in category : "+categoryId;
    }
}
