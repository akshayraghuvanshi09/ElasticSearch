package com.elk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elk.model.Product;
import com.elk.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Product insertProduct(Product product){
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product,int id){
		Product product2 = productRepository.findById(id).get();
		product2.setPrice(product.getPrice());
		product2.setDescription(product.getDescription());
		product2.setName(product.getName());
		product2.setQuantity(product.getQuantity());
		product2.setPrice(product.getPrice());
		return product2;
		
	}
	
	public void deleteProduct(int id){
		productRepository.deleteById(id);
	}
	
}
