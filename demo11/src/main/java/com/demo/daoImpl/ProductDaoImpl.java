package com.demo.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao 
{
	 @Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product product) {
		Session session=sessionFactory.openSession();
		session.save(product);

		session.close();
	}

	public List<Product> getAllProducts()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> products=query.list();
		session.close();
		return products;
		
	}

	public Product getProductById(int productId) {
		Session session =sessionFactory.openSession();
		Product product=(Product)session.get(Product.class, productId);
		session.close();
		return product;
	}

	public void deleteProduct(int productId) {
		Session session =sessionFactory.openSession();
		Product product=(Product)session.get(Product.class, productId);
		session.delete(product);
		session.flush();
		session.close();
		
	}

	public void editProduct(Product product) {
		Session session =sessionFactory.openSession();
		System.out.println("Id of the product dao is" + product.getProductId());
		session.update(product);
		session.flush();
		session.close();
	}
		
}