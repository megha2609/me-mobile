package com.demo.service;

import java.util.List;

import com.demo.model.Category;
import com.demo.model.Product;

public interface CategoryService {
	
	 void addCategory(Category category);
	 
	 List<Category> getAllCategory();
	 Category getCategoryById(int cid);
		
	 void deleteCategory(int cid);

	 Category getByName(String name);
	 
}
