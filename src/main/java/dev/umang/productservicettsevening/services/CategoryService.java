package dev.umang.productservicettsevening.services;

import dev.umang.productservicettsevening.modals.Product;

import java.util.List;

public interface CategoryService {

    List<String> getAllCategories();


    List<Product> getProductsInCategory(String categoryId);
}
