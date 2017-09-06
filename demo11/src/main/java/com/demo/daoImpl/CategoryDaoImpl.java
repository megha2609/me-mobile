package com.demo.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CategoryDao;
import com.demo.dao.ProductDao;
import com.demo.model.Category;
import com.demo.model.Product;



	
	@Repository
	@Transactional
	public class CategoryDaoImpl implements CategoryDao
	{
		 @Autowired
		private SessionFactory sessionFactory;

		public void addCategory(Category category) {
			Session session=sessionFactory.openSession();
			session.save(category);
			session.flush();
			session.close();
		}

		public List<Category> getAllCategory() {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Category");
			List<Category> categories=query.list();
			session.close();
			return categories;
		}
		public Category getCategoryById(int cid) {
			Session session=sessionFactory.openSession();
			Category category=(Category)session.get(Category.class, cid);
			session.close();
			return category;
		}

		public void deleteCategory(int cid) {
			Session session=sessionFactory.openSession();
			Category category=(Category)session.get(Category.class, cid);
			session.delete(category);
			session.flush();
			session.close();
			
			
		}

		public Category getByName(String name) {
			 String hql="from Category where categoryDetails=?";
	        Query query=sessionFactory.openSession().createQuery(hql);
	        query.setString(0, name);
	        List<Category> listCategory=(List<Category>) query.list();
	        if (listCategory != null && !listCategory.isEmpty()) {
	              return listCategory.get(0);
	        }
	        else
	        {
	              return null;                 
	        }

		}

		
		

		
			
	}


