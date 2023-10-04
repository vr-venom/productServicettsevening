package dev.umang.productservicettsevening.services;

import dev.umang.productservicettsevening.clients.fakeStoreApi.CategoryClient;
import dev.umang.productservicettsevening.clients.fakeStoreApi.FakeStoreCategoryDto;
import dev.umang.productservicettsevening.clients.fakeStoreApi.FakeStoreProductDto;
import dev.umang.productservicettsevening.modals.Category;
import dev.umang.productservicettsevening.modals.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    RestTemplateBuilder restTemplateBuilder;
    CategoryClient categoryClient;

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto){
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
    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder, CategoryClient categoryClient){
        this.restTemplateBuilder = restTemplateBuilder;
        this.categoryClient = categoryClient;
    }
    @Override
    public List<String> getAllCategories() {
        //List<CategoryDto> categoryDtos =
        return categoryClient.getAllCategories();
    }

    @Override
    public List<Product> getProductsInCategory(String categoryId) {

        List<FakeStoreProductDto> fakeStoreProductDtoList = categoryClient.getProductsInCategory(categoryId);
        List<Product> answer = new ArrayList<>();
        for (FakeStoreProductDto productDto:fakeStoreProductDtoList){
            answer.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return answer;
    }
}
