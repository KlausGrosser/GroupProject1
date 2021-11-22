package com.dci.mcomm.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.dci.mcomm.entity.Product;
import com.dci.mcomm.service.ProductService;
import com.dci.mcomm.utils.Utils;

public class ProductServiceImpl implements ProductService {

	Scanner input = new Scanner(System.in);
	private final List<Product> PRODUCTS_LIST = new LinkedList<>();
	

	// collect details of a new Product and add to the list
	@Override
	public Product add() {
		Product added = new Product();

		System.out.println("Enter name of new product:");
		String catName = input.nextLine();
		added.setLabel(catName);

		System.out.println("Enter id number of new product:");
		int id = Integer.parseInt(input.nextLine());
		added.setId(id);

		System.out.println("Enter category id number of new product:");
		int categoryId = Integer.parseInt(input.nextLine());
		added.setCategoryId(categoryId);

		System.out.println("Enter description of new product:");
		String description = input.nextLine();
		added.setDescription(description);

		System.out.println("Enter unit price of new product:");
		double unitPrice = Double.parseDouble(input.nextLine());
		added.setUnitPrice(unitPrice);

		this.add(added);

		return added;
	}

	// add a new Product to the list
	@Override
	public Product add(Product product) {
		PRODUCTS_LIST.add(product);
		return product;
	}

	// collect new details of an existing Product and update the list
	@Override
	public Product update(int id) {
		return update(this.find(id));
	}

	// update an existing Product in the list
	@Override
	public Product update(Product product) {
		if(Utils.confirm("Do you want to update the Id?")){
			System.out.println("Enter new Id number:");
			int newId = Integer.parseInt(input.nextLine());
			product.setId(newId);
		}

		if(Utils.confirm("Do you want to update the Category Id?")){
			System.out.println("Enter new Category Id number:");
			int newCategoryId = Integer.parseInt(input.nextLine());
			product.setCategoryId(newCategoryId);
		}

		if(Utils.confirm("Do you want to update the product's name?")){
			System.out.println("Enter new name:");
			String newLabel = input.nextLine();
			product.setLabel(newLabel);
		}

		if(Utils.confirm("Do you want to update the product's description?")){
			System.out.println("Enter new description:");
			String description = input.nextLine();
			product.setDescription(description);
		}
		if(Utils.confirm("Do you want to update the product's unit price?")){
			System.out.println("Enter new unit price:");
			double newUnitPrice = Double.parseDouble(input.nextLine());
			product.setUnitPrice(newUnitPrice);
		}
		return product;
	}

	// remove a matching Product from the list
	@Override
	public Product remove(int id) {
		Product removed = this.find(id);
		list().remove(removed);
		return removed;
	}

	// identify a matching Product in the list
	@Override
	public Product find(int id) {
		Product found = new Product();
		for (Product iterator : list()){
			if (iterator.getId() == id){
				found = iterator;
			}
		}
		return found;
	}

	// access the current list of Products
	@Override
	public List<Product> list() {
		return PRODUCTS_LIST;
	}

}
