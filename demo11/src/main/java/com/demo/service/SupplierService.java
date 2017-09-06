package com.demo.service;

import java.util.List;

import com.demo.model.Supplier;

public interface SupplierService
{

	void addSupplier(Supplier supplier);
	List<Supplier> getAllSupplier();
	
void deleteSupplier(int supid);
	
	Supplier getByName(String name);
}
