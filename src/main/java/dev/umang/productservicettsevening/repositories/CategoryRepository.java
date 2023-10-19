package dev.umang.productservicettsevening.repositories;

import dev.umang.productservicettsevening.models.Category;
import dev.umang.productservicettsevening.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);
     List<Category> findAll();

    List<Long> findCategoryIdByName(String categoryName);

    List<Category> findByName(String categoryName);
}
