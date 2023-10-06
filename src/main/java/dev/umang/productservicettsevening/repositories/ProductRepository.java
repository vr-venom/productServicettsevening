package dev.umang.productservicettsevening.repositories;

import dev.umang.productservicettsevening.modals.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);
}
