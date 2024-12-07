package com.example.elasticsearch.elasticsearch.repo;

import com.example.elasticsearch.elasticsearch.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends ElasticsearchRepository<Product,Long> {

}
