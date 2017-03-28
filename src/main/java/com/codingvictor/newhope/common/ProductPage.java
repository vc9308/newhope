package com.codingvictor.newhope.common;

import java.util.List;

import com.codingvictor.newhope.entity.Product;

public class ProductPage extends Page {
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
