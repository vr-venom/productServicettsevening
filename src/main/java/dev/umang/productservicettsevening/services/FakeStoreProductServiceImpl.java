package dev.umang.productservicettsevening.services;

import dev.umang.productservicettsevening.dtos.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductServiceImpl implements ProductService {
    @Override
    public String getAllProducts() {
        return null;
    }

    @Override
    public String getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public String addNewProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public String updateProduct(Long productId) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }

    @Override
    public String returnProduct() {
        return null;
    }
}
