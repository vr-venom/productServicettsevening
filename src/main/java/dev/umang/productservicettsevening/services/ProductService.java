package dev.umang.productservicettsevening.services;

import dev.umang.productservicettsevening.dtos.ProductDto;
import dev.umang.productservicettsevening.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();


    Optional<Product> getSingleProduct(Long productId);


    Product addNewProduct(ProductDto product);


    Product updateProduct( Long productId , Product product);

    Product replaceProduct( Long productId , Product product);


    Product deleteProduct(Long productId);


}
