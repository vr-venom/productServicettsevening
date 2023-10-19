package dev.umang.productservicettsevening;

import dev.umang.productservicettsevening.models.Category;
import dev.umang.productservicettsevening.models.Product;
import dev.umang.productservicettsevening.repositories.CategoryRepository;
import dev.umang.productservicettsevening.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    void savingProductsAndCategory( ){
        Product product = new Product();
        Category category = new Category();
        category.setName("Electronics");
        Category savedCategory = categoryRepository.save(category);
//        product.setPrice(100);
//        product.setImgURL("hello");
//        product.setCategory(savedCategory);
//        productRepository.save(product);
    }
    @Test
    @Transactional
    void fetchTypesTest(){
        Product product  = productRepository.findProductsById(1L);
        Category category = product.getCategory();
        String name = category.getName();
    }


}
