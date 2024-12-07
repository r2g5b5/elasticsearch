package com.example.elasticsearch.elasticsearch.controller;

import com.example.elasticsearch.elasticsearch.entity.Product;
import com.example.elasticsearch.elasticsearch.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findAll")
    Iterable<Product> findAll(){
        return productService.getProducts();

    }

    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }


}
