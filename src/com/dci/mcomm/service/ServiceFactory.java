package com.dci.mcomm.service;

import com.dci.mcomm.service.impl.ProductCategoryServiceImpl;
import com.dci.mcomm.service.impl.ProductServiceImpl;

public class ServiceFactory {

	private static ProductCategoryService _categoryService;
	private static ProductService _productService;
	
	public static ProductCategoryService getProductCategoryService() {
		if(_categoryService == null) {
			_categoryService = new ProductCategoryServiceImpl();
		}
		return _categoryService;
	}

	public static ProductService getProductService() {
		if(_productService == null) {
			_productService = new ProductServiceImpl();
		}
		return _productService;
	}
}
