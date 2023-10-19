package dev.umang.productservicettsevening.clients.fakeStoreApi;

import dev.umang.productservicettsevening.models.Category;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class CategoryClient {
    private RestTemplateBuilder restTemplateBuilder;
    public CategoryClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    public List<Category> getAllCategories() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class
        );
        List<String> answer = new ArrayList<>();
        for (String s : response.getBody()) {
            answer.add(s);
        }
        return null;
    }

    public List<FakeStoreProductDto> getProductsInCategory(String categoryId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/category/{id}",
                FakeStoreProductDto[].class,
                categoryId
        );
        return Arrays.asList(response.getBody());
    }
}
