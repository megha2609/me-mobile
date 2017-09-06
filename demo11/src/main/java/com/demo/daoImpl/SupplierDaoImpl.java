package com.demo.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.SupplierDao;
import com.demo.model.Supplier;



	
	@Repository
	@Transactional
	public class SupplierDaoImpl implements SupplierDao
	{
		 @Autowired
		private SessionFactory sessionFactory;

		public void addSupplier(Supplier supplier) {
			Session session=sessionFactory.openSession();
			session.save(supplier);
			session.flush();
			session.close();
		}

		public List<Supplier> getAllSupplier() {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Supplier");
			List<Supplier> supplier=query.list();
			session.close();
			return supplier;
		}
		
		public Supplier getSupplierById(int supid) {
			Session session=sessionFactory.openSession();
			Supplier supplier=(Supplier)session.get(Supplier.class, supid);
			session.close();
			return supplier;
		}

		public void deleteSupplier(int supid) {
			Session session=sessionFactory.openSession();
			Supplier supplier=(Supplier)session.get(Supplier.class, supid);
			session.delete(supplier);
			session.flush();
			session.close();
			
			
		}

		public Supplier getByName(String name) {
			 String hql="from Supplier where supplierDetails=?";
		        Query query=sessionFactory.openSession().createQuery(hql);
		        query.setString(0, name);
		        List<Supplier> listSupplier=(List<Supplier>) query.list();
		        if (listSupplier != null && !listSupplier.isEmpty()) {
		              return listSupplier.get(0);
		        }
		        else
		        {
		              return null;                 
		        }
		
		
}
}