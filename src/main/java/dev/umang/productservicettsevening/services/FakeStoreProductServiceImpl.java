package dev.umang.productservicettsevening.services;

import dev.umang.productservicettsevening.clients.fakeStoreApi.FakeStoreClient;
import dev.umang.productservicettsevening.clients.fakeStoreApi.FakeStoreProductDto;
import dev.umang.productservicettsevening.dtos.ProductDto;
import dev.umang.productservicettsevening.modals.Category;
import dev.umang.productservicettsevening.modals.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;
    public FakeStoreProductServiceImpl( RestTemplateBuilder restTemplateBuilder,FakeStoreClient fakeStoreClient){
        this.restTemplateBuilder= restTemplateBuilder;
        this.fakeStoreClient=fakeStoreClient;
    }
    private  <T> ResponseEntity<T> requestForEntity(
            HttpMethod httpMethod,
            String url,
            @Nullable Object request,
            Class<T> responseType,
            Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

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

    @Override
    public List<Product> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClient.getAllProducts();
        List<Product> answer = new ArrayList<>();

        for(FakeStoreProductDto productDto :fakeStoreProductDtos){
            answer.add(convertFakeStoreProductDtoToProduct(productDto));
        }

        return answer;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {

        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.getSingleProduct(productId);
        if(fakeStoreProductDto==null){
            return Optional.empty();
        }
        return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
    }

    @Override
    public Product addNewProduct(ProductDto product) {

        FakeStoreProductDto productDto = fakeStoreClient.addNewProduct(product);

        return convertFakeStoreProductDtoToProduct(productDto);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.updateProduct(productId,product);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.updateProduct(productId,product);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product deleteProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.deleteProduct(productId);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }
}
