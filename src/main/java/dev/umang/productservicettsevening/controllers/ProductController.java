package dev.umang.productservicettsevening.controllers;

import dev.umang.productservicettsevening.dtos.GetSingleProductResponseDto;
import dev.umang.productservicettsevening.dtos.ProductDto;
import dev.umang.productservicettsevening.modals.Product;
import dev.umang.productservicettsevening.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController ( ProductService productService){
        this.productService = productService;
    }
    @GetMapping("")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public GetSingleProductResponseDto getSingleProduct(@PathVariable("productId") Long productId){
        GetSingleProductResponseDto responseDto = new GetSingleProductResponseDto();
        responseDto.setProduct(productService.getSingleProduct(productId));

        return responseDto;
    }

    @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product){
        Product newProduct = productService.addNewProduct(product);
        ResponseEntity<Product> response = new ResponseEntity<>(newProduct, HttpStatus.OK);
        return response;

    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto ){
        return "Updating product to : " +productDto  ;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "deleting product with id : "+ productId;
    }

}
