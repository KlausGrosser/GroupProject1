package com.dci.mcomm;

import java.util.Scanner;

import com.dci.mcomm.entity.Product;
import com.dci.mcomm.entity.ProductCategory;
import com.dci.mcomm.service.ProductCategoryService;
import com.dci.mcomm.service.ProductService;
import com.dci.mcomm.service.ServiceFactory;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean doMore = true;
		do {
			System.out.println("#############################################################");
			System.out.println("###################### MENU: Management #######################");

			System.out.println("Management Option: (Enter number before option)");
			System.out.println("1. Product Category");
			System.out.println("2. Product");
			System.out.println("0. Exit");

			System.out.print("Option selected: ");
			int selection = input.nextInt();

			switch (selection) {
			case 1:
				manageCategory();
				break;
			case 2:
				manageProducts();
				break;
			case 0:
				doMore = false;
			}
		} while (doMore);
		
		System.out.println("######################## THANK YOU ##########################");
		System.out.println("#############################################################");
	}

	private static void manageCategory() {
		Scanner input = new Scanner(System.in);
		ProductCategoryService catService = ServiceFactory.getProductCategoryService();
		boolean doMore = true;
		do {
			System.out.println("#############################################################");
			System.out.println("################## MENU: Product Category ###################");

			System.out.println("Product Category:: Select Option: (Enter number before option)");
			System.out.println("1. Add New");
			System.out.println("2. Update Existing");
			System.out.println("3. Remove Existing");
			System.out.println("4. List All");
			System.out.println("0. Go Back");

			System.out.print("Option selected: ");
			int selection = input.nextInt();

			switch (selection) {
			case 1:
				ProductCategory added = catService.add();
				if(added != null) {
					System.out.println(String.format("Added Category - %s", added.toString()));
				}
				break;
			case 2:
				System.out.print("Enter the ID to update:");
				int idToUpdate = input.nextInt();
				ProductCategory updated = catService.update(idToUpdate);
				if(updated != null) {
					System.out.println(String.format("Updated Category - %s", updated.toString()));
				}
				break;
			case 3:
				System.out.print("Enter the ID to remove:");
				int idToRemove = input.nextInt();
				ProductCategory removed = catService.remove(idToRemove);
				if(removed != null) {
					System.out.println(String.format("Removed Category - %s", removed.toString()));
				}
				break;
			case 4:
				System.out.print("List of Product Categories:");
				System.out.println(catService.list());
				break;
			case 0:
				doMore = false;
			}
		} while (doMore);

		System.out.println("############## END: Product Category Management #############");
		System.out.println("#############################################################");
	}
	
	private static void manageProducts() {
		Scanner input = new Scanner(System.in);
		ProductService productService = ServiceFactory.getProductService();
		boolean doMore = true;
		do {
			System.out.println("#############################################################");
			System.out.println("###################### MENU: Products #######################");

			System.out.println("Product :: Select Option: (Enter number before option)");
			System.out.println("1. Add New");
			System.out.println("2. Update Existing");
			System.out.println("3. Remove Existing");
			System.out.println("4. List All");
			System.out.println("0. Go Back");

			System.out.print("Option selected: ");
			int selection = input.nextInt();

			switch (selection) {
			case 1:
				Product added = productService.add();
				if(added != null) {
					System.out.println(String.format("Added Product - %s", added.toString()));
				}
				break;
			case 2:
				System.out.print("Enter the ID to update:");
				int idToUpdate = input.nextInt();
				Product updated = productService.update(idToUpdate);
				if(updated != null) {
					System.out.println(String.format("Updated Product - %s", updated.toString()));
				}
				break;
			case 3:
				System.out.print("Enter the ID to remove:");
				int idToRemove = input.nextInt();
				Product removed = productService.remove(idToRemove);
				if(removed != null) {
					System.out.println(String.format("Removed Product - %s", removed.toString()));
				}
				break;
			case 4:
				System.out.print("List of Products:");
				System.out.println(productService.list());
				break;
			case 0:
				doMore = false;
			}
		} while (doMore);

		System.out.println("################## END: Product Management ##################");
		System.out.println("#############################################################");
	}
}
