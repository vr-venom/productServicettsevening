package dev.umang.productservicettsevening.repositories;

import dev.umang.productservicettsevening.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);
    Product findProductsById( Long id);
    List<Product> findAllByCategoryIdIn(List<Long> id);
    List<Product> findAll();
    Product deleteProductById(Long id);

    Product findProductsByCategoryId (Long id);
}
