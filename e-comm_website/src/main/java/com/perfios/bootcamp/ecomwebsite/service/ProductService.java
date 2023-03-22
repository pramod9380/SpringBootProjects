package com.perfios.bootcamp.ecomwebsite.service;


import com.perfios.bootcamp.ecomwebsite.beans.Product;
import com.perfios.bootcamp.ecomwebsite.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();
    void saveProduct(Product product);
    Product getProductById(int id) throws ProductNotFoundException;
    Product updateProductById(int id) throws ProductNotFoundException;
    void deleteProductById(int id) throws ProductNotFoundException;

    List<Product> findAllProductsByCategoryId(int id);

}
