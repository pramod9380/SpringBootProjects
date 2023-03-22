package com.perfios.bootcamp.ecomwebsite.serviceimpl;

import com.perfios.bootcamp.ecomwebsite.beans.Product;
import com.perfios.bootcamp.ecomwebsite.exception.ProductNotFoundException;
import com.perfios.bootcamp.ecomwebsite.repository.ProductRepo;
import com.perfios.bootcamp.ecomwebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product getProductById(int id) throws ProductNotFoundException {
        productRepo.findById(id).orElseThrow(()-> new ProductNotFoundException("product not exist with this id:"));
        return productRepo.findById(id).get();
    }

    @Override
    public Product updateProductById(int id) throws ProductNotFoundException {
        productRepo.findById(id).orElseThrow(()-> new ProductNotFoundException("product not exist with this id:"));
        return productRepo.findById(id).get();
    }

    @Override
    public void deleteProductById(int id) throws ProductNotFoundException {
        productRepo.findById(id).orElseThrow(()-> new ProductNotFoundException("product not exist with this id:"));
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> findAllProductsByCategoryId(int id) {
        return productRepo.findAllProductsByCategoryId(id);
    }
}
