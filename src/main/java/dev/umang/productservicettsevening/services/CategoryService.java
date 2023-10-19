package dev.umang.productservicettsevening.services;

import dev.umang.productservicettsevening.models.Category;
import dev.umang.productservicettsevening.models.Product;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();


    List<Product> getProductsInCategory(String categoryId);
}
