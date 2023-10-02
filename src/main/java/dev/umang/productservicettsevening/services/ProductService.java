package dev.umang.productservicettsevening.services;

import dev.umang.productservicettsevening.dtos.ProductDto;
import dev.umang.productservicettsevening.modals.Category;
import dev.umang.productservicettsevening.modals.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();


    Product getSingleProduct( Long productId);


    Product addNewProduct(ProductDto product);


    Product updateProduct( Long productId , Product product);


    Boolean deleteProduct( Long productId);


}
