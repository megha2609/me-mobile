package com.demo.daoImpl;


import com.demo.dao.CartDao;
import com.demo.model.Cart;
import com.demo.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    

    @Autowired
    private CustomerOrderService customerOrderService;

    public Cart getCartById(int cartId){
        Session session = sessionFactory.openSession();
        Cart cart = (Cart) session.get(Cart.class, cartId);
        session.close();
        return cart;
    }

    public void update(Cart cart){
        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.openSession();
        session.saveOrUpdate(cart);
        session.flush();
        session.close();
    }

    public Cart validate(int cartId) throws IOException{
        Cart cart = getCartById(cartId);
        if(cart == null || cart.getCartItems().size() == 0){
            throw new IOException(cartId + "");
        }

        update(cart);
        return cart;
    }


}
