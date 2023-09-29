package dev.umang.productservicettsevening.controllers;

import dev.umang.productservicettsevening.dtos.ProductDto;
import dev.umang.productservicettsevening.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController ( ProductService productService){
        this.productService = productService;
    }
    @GetMapping("")
    public String getAllProducts(){
        return "Getting all products";
    }

    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId){
        return "Returning Single product with ID : " +productId;
    }

    @PostMapping("")
    public String addNewProduct(@RequestBody ProductDto productDto){
        return "Adding new product " + productDto;
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto ){
        return "Updating product to : " +productDto  ;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "deleting product with id : "+ productId;
    }
    public String returnProduct(){
        return "returning product";
    }
}
