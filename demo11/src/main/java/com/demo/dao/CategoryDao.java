package com.demo.dao;

import java.util.List;

import com.demo.model.Category;
import com.demo.model.Product;

public interface CategoryDao {
	void addCategory(Category category);
	
	//to show product in h2
    List<Category> getAllCategory();
    

	Category getCategoryById(int cid);
	
void deleteCategory(int cid);

 Category getByName(String name);
    
}
