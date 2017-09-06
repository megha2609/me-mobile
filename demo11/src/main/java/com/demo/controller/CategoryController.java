package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/addCategory")
	public String addCategory(Model model) {
		Category category = new Category();
		model.addAttribute("categorycommand", category);

		return "addCategory";
	}

	@RequestMapping("addCategoryPost")
	public String addCategoryPost(@ModelAttribute("categorycommand") Category category) {
		categoryService.addCategory(category);
		return "addCategory";

	}
	
	@RequestMapping("/catList")
    public String getAllCategory(Model model)
    {
    	List<Category> category=categoryService.getAllCategory();
    	//Assigning list of products to model attribute category
    	model.addAttribute("categoryList",category);
    	return "categorylist";
    }
}
