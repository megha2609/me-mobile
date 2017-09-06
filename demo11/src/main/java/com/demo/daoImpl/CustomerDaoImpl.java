package com.demo.daoImpl;

import java.util.List;

import com.demo.dao.CustomerDao;
import com.demo.model.Customer;
import com.demo.model.Users;
import com.demo.model.Cart;
import com.demo.model.Authorities;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao
{ 
	@Autowired
    private SessionFactory sessionFactory;

			public void addCustomer(Customer customer) {
		        Session session = sessionFactory.openSession();

		        customer.getBillingAddress().setCustomer(customer);
		        customer.getShippingAddress().setCustomer(customer);

		        session.saveOrUpdate(customer);
		        session.saveOrUpdate(customer.getBillingAddress());
		        session.saveOrUpdate(customer.getShippingAddress());

		        Users newUser = new Users();
		        newUser.setUsername(customer.getUsername());
		        newUser.setPassword(customer.getPassword());
		        newUser.setEnabled(true);
		        customer.getUsers();
		        customer.setUsers(newUser);
		        
		        Authorities newAuthorities = new Authorities();
		        newAuthorities.setUsername(customer.getUsername());
		        newAuthorities.setAuthority("ROLE_USER");

		        session.saveOrUpdate(newUser);
		        session.saveOrUpdate(newAuthorities);

		        Cart newCart = new Cart();
		        newCart.setCustomer(customer);
		        customer.setCart(newCart);

		        session.saveOrUpdate(customer);
		        session.saveOrUpdate(newCart);

		        session.flush();
		        
		    }

	public Customer getCustomerById(int customerId) {
		Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
	}

	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;
	}

	public Customer getCustomerByUsername(String username) {
		 Session session = sessionFactory.openSession();
		 System.out.println("hello");
	        Query query = session.createQuery("from Users where username = ?");
	        query.setString(0, username);
	        
	        Users users= (Users) query.uniqueResult();
	        Customer customer = users.getCustomer();
	        session.close();
	        return customer;
	       




	}
	

}
