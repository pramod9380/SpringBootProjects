package com.perfios.bootcamp.ecomwebsite.repository;

import com.perfios.bootcamp.ecomwebsite.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findAllProductsByCategoryId(int id);
}
