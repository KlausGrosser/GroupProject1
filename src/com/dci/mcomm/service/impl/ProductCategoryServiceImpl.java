package com.dci.mcomm.service.impl;

import java.util.*;

import com.dci.mcomm.entity.ProductCategory;
import com.dci.mcomm.service.ProductCategoryService;
import com.dci.mcomm.utils.Utils;

public class ProductCategoryServiceImpl implements ProductCategoryService {

	Scanner input = new Scanner(System.in);
	private final List<ProductCategory> CATEGORIES_LIST = new LinkedList<>();


	// collect details of a new ProductCategory and add to the list
	@Override
	public ProductCategory add() {
		ProductCategory added = new ProductCategory();

		System.out.println("Enter name of new category:");
		String catName = input.nextLine();
		added.setLabel(catName);

		System.out.println("Enter id number of new category");
		int categoryId = Integer.parseInt(input.nextLine());
		added.setId(categoryId);

		System.out.println("Is the category active?");
		String answer = input.nextLine();
		boolean active = answer.toLowerCase().startsWith("y");
		added.setActive(active);

		this.add(added);
		return added;
	}

	// add a new ProductCategory to the list
	@Override
	public ProductCategory add(ProductCategory category) {
		CATEGORIES_LIST.add(category);
		return category;
	}

	// collect new details of an existing ProductCategory and update the list
	@Override
	public ProductCategory update(int id) {
		return update(this.find(id));
	}

	// update an existing ProductCategory in the list
	@Override
	public ProductCategory update(ProductCategory category) {
		if(Utils.confirm("Do you want to update the Id?")){
			System.out.println("Enter new Id number:");
			int newId = Integer.parseInt(input.nextLine());
			category.setId(newId);
		}
		if(Utils.confirm("Do you want to update the category name?")){
			System.out.println("Enter new name:");
			String newLabel = input.nextLine();
			category.setLabel(newLabel);
		}
		if(Utils.confirm("Do you want to update the category status?")){
			if (Utils.confirm("Enter 'yes' to activate or 'no' to deactivate:")){
				category.setActive(true);
			}
		}
		return category;
	}

	// remove a matching ProductCategory from the list
	@Override
	public ProductCategory remove(int id) {
		ProductCategory removed = this.find(id);
		list().remove(removed);
		return removed;
	}

	// identify a matching ProductCategory in the list
	@Override
	public ProductCategory find(int id) {
		ProductCategory found = new ProductCategory();
		for (ProductCategory iterator : list()){
			if (iterator.getId() == id){
				found = iterator;
			}
		}
		return found;
	}

	// access the current list of ProductCategories
	@Override
	public List<ProductCategory> list() {
		return CATEGORIES_LIST;
	}

}
