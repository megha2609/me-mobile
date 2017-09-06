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
import com.demo.model.Customer;
import com.demo.service.CustomerService;
import com.demo.model.BillingAddress;
import com.demo.model.ShippingAddress;



@Controller
public class CustomerController 
{
	

	    @Autowired
	    private CustomerService customerService;

	    @RequestMapping("/register")
	    public String registerCustomer(Model model){
	        Customer customer = new Customer();
	        
	        
	        BillingAddress billingAddress = new BillingAddress();
	        ShippingAddress shippingAddress = new ShippingAddress();
	        customer.setBillingAddress(billingAddress);
	        customer.setShippingAddress(shippingAddress);

	        model.addAttribute("customer", customer);

	        return "registerCustomer";
	    }

//submit
	    @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){

	        if(result.hasErrors()){
	            return "registerCustomer";
	        }

	        /*List<Customer> customerList = customerService.getAllCustomers();

	        for (int i=0; i< customerList.size(); i++){
	            if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())){
	                model.addAttribute("emailMsg", "Email already exists");

	                return "registerCustomer";
	            }

	            if(customer.getUsername().equals(customerList.get(i).getUsername())){
	                model.addAttribute("usernameMsg", "Username already exists");

	                return "registerCustomer";
	            }
	        }

	        customer.setEnabled(true);*/
	        customerService.addCustomer(customer);
	        return "registerCustomer";
	    }
	    

	   


	       
	       // customerService.addCustomer(customer);
	        
	    }
	



