package com.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.SupplierDao;
import com.demo.model.Supplier;
import com.demo.service.SupplierService;





	
	@Service
	public class SupplierServiceImpl implements SupplierService
	{
		@Autowired
	    private SupplierDao supplierDao;

		public void addSupplier(Supplier supplier) {
			supplierDao.addSupplier(supplier);
			
		}

		public List<Supplier> getAllSupplier() {
			return supplierDao.getAllSupplier();
		}
	
		public Supplier getSupplierById(int supid) {
			
			return supplierDao.getSupplierById(supid);
		}

		public void deleteSupplier(int supid) {
			supplierDao.deleteSupplier(supid);
			
		}
		public Supplier getByName(String name) {
			return supplierDao.getByName(name);
			
		}
}
