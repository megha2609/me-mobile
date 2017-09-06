package com.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.model.Supplier;
import com.demo.service.CategoryService;
import com.demo.service.ProductService;
import com.demo.service.SupplierService;

@Controller
public class ProductController {
	
	
	private Path path;
	@Autowired
	private ProductService productService;
	//category and supplier service used for delete and edit operation
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SupplierService supplierService;
	

	@RequestMapping("/addProduct")
	public String addProduct(Model model , Product p) {
		Product product = new Product();
		model.addAttribute("productcommand", product);
		
		
		model.addAttribute("category", new Category());
		List<Category> categoryDetails = categoryService.getAllCategory();
		System.out.println(categoryDetails);
		model.addAttribute("categorydetails",categoryDetails);
		
		model.addAttribute("supplier", new Supplier());
		List<Supplier> supplierDetails = supplierService.getAllSupplier();
		model.addAttribute("supplierdetails",supplierDetails);
		
	
		return "addProduct";
	}
	


	// submit button mapping
	@RequestMapping("/addProductPost")
	public String addProductPost(@Valid @ModelAttribute("productcommand") Product product, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors())
			return "addProduct";
		Category category= categoryService.getByName(product.getCategory().getCategoryDetails());
        product.setCategory(category);
         Supplier supplier=supplierService.getByName(product.getSupplier().getSupplierDetails());
        product.setSupplier(supplier);
		productService.addProduct(product);
		//multipart
		MultipartFile productImage = product.getImage();
	        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".jpg");

	        if(productImage != null && !productImage.isEmpty()){
	            try {
	                productImage.transferTo(new File(path.toString()));
	            } catch (Exception ex){
	                ex.printStackTrace();
	                throw new RuntimeException("Product image saving failed", ex);
	            }
	        }
			
		
		return "redirect:/prodList";
		}
		
		
		
	

	// to view all product in list
	@RequestMapping("/prodList")
	public String getAllProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		// Assigning list of products to model attribute products
		model.addAttribute("productList", products);
		return "productlist";
	}

	@RequestMapping("/deleteproduct/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		return "redirect:/prodList";

	}
	
	@RequestMapping("/editform/{productId}")
	public String editProductForm(@PathVariable int productId,Model model)
	{
		model.addAttribute("product1",productService.getProductById(productId));
		System.out.println("Product id:" +productId);
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("suppliers",supplierService.getAllSupplier());
	    return "editproductform";
	}
	
	@RequestMapping("/editProduct/{productId}")
	public String editProductDetails(@Valid @ModelAttribute("product1") Product product, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors())
			return "editproductform";	
		productService.editProduct(product);
		return "redirect:/prodList";
	}
	
	@RequestMapping("/vviewproduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) {
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "vviewproduct";
	}
	
	

	
}