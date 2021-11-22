package com.dci.mcomm.service;

import java.util.List;

import com.dci.mcomm.entity.ProductCategory;

public interface ProductCategoryService {
	// collect details of a new ProductCategory and add to the list
	public ProductCategory add();

	// add a new ProductCategory to the list
	public ProductCategory add(ProductCategory category);
	
	// collect new details of an existing ProductCategory and update the list
	public ProductCategory update(int id);

	// update an existing ProductCategory in the list
	public ProductCategory update(ProductCategory category);
	
	// remove a matching ProductCategory from the list
	public ProductCategory remove(int id);

	// identify a matching ProductCategory in the list
	public ProductCategory find(int id);
	
	// access the current list of ProductCategories
	public List<ProductCategory> list();
	
}
