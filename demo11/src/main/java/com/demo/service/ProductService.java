package com.demo.service;

import java.util.List;

import com.demo.model.Product;


public interface ProductService {

   void addProduct(Product product);
   
   List<Product> getAllProducts();

   Product getProductById(int productId);
   
   void deleteProduct(int id);
   
   void editProduct(Product product);

}
