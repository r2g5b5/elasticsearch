package com.example.elasticsearch.elasticsearch.service;

import com.example.elasticsearch.elasticsearch.entity.Product;
import com.example.elasticsearch.elasticsearch.repo.ProductRepo;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product insertProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Product product, Long id) {
        Product product1 = productRepo.findById(id).orElseThrow();
        product1.setPrice(product.getPrice());
        return product1;
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
