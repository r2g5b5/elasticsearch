package com.example.elasticsearch.elasticsearch.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.elasticsearch.elasticsearch.entity.Product;
import com.example.elasticsearch.elasticsearch.service.ElasticSearchService;
import com.example.elasticsearch.elasticsearch.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/apis")
public class ProductController {

    private final ProductService productService;
    private final ElasticSearchService elasticSearchService;

    public ProductController(ProductService productService, ElasticSearchService elasticSearchService) {
        this.productService = productService;
        this.elasticSearchService = elasticSearchService;
    }

    @GetMapping("/findAll")
    Iterable<Product> findAll() {
        return productService.getProducts();

    }

    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @Param("id") Long id) {
        return productService.updateProduct(product, id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@Param("id") Long id) {
        productService.deleteProduct(id);
    }


    @GetMapping("/matchAll")
    public SearchResponse<Map> matchAll() throws IOException {
        SearchResponse<Map> searchResponse = elasticSearchService.search();
        System.out.println(searchResponse.hits().hits().toString());
        return searchResponse;

    }
}
