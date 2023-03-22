package com.test.Service;

import java.util.List;

import com.test.Exception.ProductAlreadyExistsException;
import com.test.model.Product;

public interface ProductService {

     Product addProduct(Product product) throws ProductAlreadyExistsException;
    List<Product> getAllProducts();
     Product getProductByid(int id);
    Product deleteProductById(int id);



}
