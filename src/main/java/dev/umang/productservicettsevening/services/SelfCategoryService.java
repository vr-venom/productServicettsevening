package dev.umang.productservicettsevening.services;

import dev.umang.productservicettsevening.models.Category;
import dev.umang.productservicettsevening.models.Product;
import dev.umang.productservicettsevening.repositories.CategoryRepository;
import dev.umang.productservicettsevening.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class SelfCategoryService implements CategoryService
{
     private CategoryRepository categoryRepository;
     private ProductRepository  productRepository;


    @Override
    public List<Category> getAllCategories() {
        return  categoryRepository.findAll();
    }

    @Override
    public List<Product> getProductsInCategory(String categoryName) {
        List<Category> categories = categoryRepository.findByName(categoryName);
        List< Product> products = new ArrayList<>();
        for(Category category: categories){
            products.add(productRepository.findProductsByCategoryId(category.getId()));
        }

        return products;
    }
}
