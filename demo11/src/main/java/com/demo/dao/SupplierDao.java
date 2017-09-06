package com.demo.dao;

import java.util.List;

import com.demo.model.Product;
import com.demo.model.Supplier;

public interface SupplierDao 
{

	void addSupplier(Supplier supplier);
	
	List<Supplier> getAllSupplier();
	
	Supplier getSupplierById(int supid);
	
	void deleteSupplier(int supid);

	Supplier getByName(String name);
}
