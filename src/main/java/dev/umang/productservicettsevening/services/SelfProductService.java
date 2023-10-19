package dev.umang.productservicettsevening.services;

import dev.umang.productservicettsevening.dtos.ProductDto;
import dev.umang.productservicettsevening.models.Category;
import dev.umang.productservicettsevening.models.Product;
import dev.umang.productservicettsevening.repositories.CategoryRepository;
import dev.umang.productservicettsevening.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll() ;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {

        return Optional.ofNullable(productRepository.findProductsById(productId));
    }

    @Override
    @Transactional
    public Product addNewProduct(ProductDto productDto) {
        Product newProduct = new Product();
        newProduct.setDescription(productDto.getDescription());
        newProduct.setImgURL(productDto.getImage());
        newProduct.setTitle(productDto.getTitle());
        newProduct.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        newProduct.setCategory(category);

        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Product newProduct = productRepository.findProductsById(productId);
        newProduct.setDescription(product.getDescription());
        newProduct.setImgURL(product.getImgURL());
        newProduct.setTitle(product.getTitle());
        newProduct.setPrice(product.getPrice());
        Category category = new Category();
        category.setName(product.getCategory().getName());
        newProduct.setCategory(category);
        return productRepository.save(newProduct);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {

        Product newProduct = productRepository.findProductsById(productId);
        newProduct.setDescription(product.getDescription());
        newProduct.setImgURL(product.getImgURL());
        newProduct.setTitle(product.getTitle());
        newProduct.setPrice(product.getPrice());
        Category category = new Category();
        category.setName(product.getCategory().getName());
        categoryRepository.save(category);
        newProduct.setCategory(category);
        return productRepository.save(newProduct);

    }

    @Override
    @Transactional
    public Product deleteProduct(Long productId) {
        Product product = productRepository.findProductsById(productId);
        product.setDeleted(true);
        return product;
    }
}
