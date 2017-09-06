package com.demo.dao;

import java.util.List;

import com.demo.model.Product;


public interface ProductDao {
    void addProduct(Product product);
     
    //to show product in h2
    List<Product> getAllProducts();
     
    Product getProductById(int productId);
    
    void deleteProduct(int productId);
    
    void editProduct(Product product);

}