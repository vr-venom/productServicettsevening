package dev.umang.productservicettsevening.controllers;

import dev.umang.productservicettsevening.clients.AuthenticationClient.AuthenticationClient;
import dev.umang.productservicettsevening.clients.AuthenticationClient.dtos.Role;
import dev.umang.productservicettsevening.clients.AuthenticationClient.dtos.SessionStatus;
import dev.umang.productservicettsevening.clients.AuthenticationClient.dtos.ValidateTokenResponseDtos;
import dev.umang.productservicettsevening.dtos.ProductDto;
import dev.umang.productservicettsevening.exceptions.NotFoundException;
import dev.umang.productservicettsevening.models.Category;
import dev.umang.productservicettsevening.models.Product;
import dev.umang.productservicettsevening.repositories.ProductRepository;
import dev.umang.productservicettsevening.services.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ProductRepository productRepository;
    private AuthenticationClient authenticationClient;
    public ProductController (@Qualifier("selfProductService") ProductService productService, ProductRepository productRepository,AuthenticationClient authenticationClient){
        this.productService = productService;
        this.productRepository = productRepository;
        this.authenticationClient = authenticationClient;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts(@Nullable @RequestHeader("AUTH_TOKEN") String token,
                                                        @Nullable @RequestHeader("USER_ID") Long userId){
//        //if token is null or userId is null then return unauthorized
//        if(token==null ||  userId==null){
//            return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
//        }
//
//        ValidateTokenResponseDtos response = authenticationClient.validate(token,userId);
//
//        //if token is invalid then return unauthorized
//        if(response.getSessionStatus().equals(SessionStatus.INVALID)){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//
//        boolean isUserAdmin = false;
//        for(Role role: response.getUserDto().getRoles()){
//            if(role.getName().equals("ADMIN")){
//                isUserAdmin = true;
//            }
//        }
//        if(!isUserAdmin){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

        Optional<Product> productOptional = productService.getSingleProduct(productId);

        if(productOptional.isEmpty()){
            throw new NotFoundException("No Product with Product id: "+productId);
        }

        ResponseEntity<Product> response = new ResponseEntity(
                productService.getSingleProduct(productId),
                headers,
                HttpStatus.NOT_FOUND
        );
        return response;
    }

    @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto product){
        Product newProduct = productService.addNewProduct(product);

        ResponseEntity<Product> response = new ResponseEntity<>(newProduct, HttpStatus.OK);
        return response;

    }

    @PatchMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto ){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImgURL(productDto.getImage());

        return productService.updateProduct(productId,product);
    }
    @PutMapping("/{productId}")
    public Product replaceProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto ){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setImgURL(productDto.getImage());

        return productService.updateProduct(productId,product);
    }

    @DeleteMapping("/{productId}")
    public Product deleteProduct(@PathVariable("productId") Long productId){
        return productService.deleteProduct(productId);
    }


}
