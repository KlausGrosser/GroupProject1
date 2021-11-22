package com.dci.mcomm.service;

import java.util.List;

import com.dci.mcomm.entity.Product;

public interface ProductService {

	// collect details of a new Product and add to the list
	public Product add();

	// add a new Product to the list
	public Product add(Product category);
	
	// collect new details of an existing Product and update the list
	public Product update(int id);

	// update an existing Product in the list
	public Product update(Product category);
	
	// remove a matching Product from the list
	public Product remove(int id);

	// identify a matching Product in the list
	public Product find(int id);
	
	// access the current list of Products
	public List<Product> list();
}
