package com.demo.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Category;
import com.demo.service.CategoryService;
import com.demo.dao.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
    private CategoryDao categoryDao;

	public void addCategory(Category category) {
		categoryDao.addCategory(category);
		
	}

	public List<Category> getAllCategory() {
		return categoryDao.getAllCategory();
	}
	
public Category getCategoryById(int cid) {
		
		return categoryDao.getCategoryById(cid);
	}

	public void deleteCategory(int cid) {
		categoryDao.deleteCategory(cid);
		
	}

	public Category getByName(String name) {
		return categoryDao.getByName(name);


	}
}
