package com.perfios.bootcamp.ecomwebsite.repository;

import com.perfios.bootcamp.ecomwebsite.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
