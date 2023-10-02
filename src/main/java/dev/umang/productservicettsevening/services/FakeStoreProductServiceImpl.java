package dev.umang.productservicettsevening.services;

import dev.umang.productservicettsevening.dtos.ProductDto;
import dev.umang.productservicettsevening.modals.Category;
import dev.umang.productservicettsevening.modals.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductServiceImpl( RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder= restTemplateBuilder;
    }



    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> l = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                    ProductDto[].class
        );
        List<Product> answer = new ArrayList<>();
        for(ProductDto productDto :l.getBody()){
            Product product = new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());
            Category category = new Category();
            category.setName(productDto.getCategory());
            product.setCategory(category);
            product.setDescription(product.getDescription());
            product.setImgURL(product.getImgURL());
            answer.add(product);
        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response =  restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",ProductDto.class,productId);
        // ( url , returnType , Parameters_in_Url..... )
        ProductDto productDto = response.getBody();
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setDescription(product.getDescription());
        product.setImgURL(product.getImgURL());
        return product;
    }

    @Override
    public Product addNewProduct(ProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> response= restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                ProductDto.class
        );
        ProductDto productDto = response.getBody();
        Product product1 = new Product();
        product1.setId(productDto.getId());
        product1.setTitle(productDto.getTitle());
        product1.setPrice(productDto.getPrice());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product1.setCategory(category);
        product1.setDescription(product1.getDescription());
        product1.setImgURL(product1.getImgURL());
        return product1;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        return null;
    }
}
