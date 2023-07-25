package com.elk.model;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products")
public class Product {

	private int id;
	private String name;
	private String description;
	private int quantity;
	private double price;
}
