package com.elk.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.elk.model.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, Integer>  {

}
