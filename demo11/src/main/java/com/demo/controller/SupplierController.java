package com.demo.controller;


	
	import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Product;
import com.demo.model.Supplier;
	import com.demo.service.SupplierService;
	@Controller
	public class SupplierController {

		   @Autowired
		    private SupplierService supplierService;

		    @RequestMapping("/addSupplier")
		    public String addSupplier(Model model){
		        Supplier supplier= new Supplier();
		        model.addAttribute("suppliercommand", supplier);

		        return "addSupplier";
		    }

		    @RequestMapping("addSupplierPost")
		    public String addCategoryPost( @ModelAttribute("suppliercommand") Supplier supplier)
		    {
		        supplierService.addSupplier(supplier);
		        return "addSupplier";
		    }
		    
		  //to view all supplier in list
		    @RequestMapping("/suppList")
		    public String getAllSupplier(Model model)
		    {
		    	List<Supplier> supplier=supplierService.getAllSupplier();
		    	//Assigning list of supplier to model attribute supplier
		    	model.addAttribute("supplierList",supplier);
		    	return "supplierlist";
		    }
	}
	