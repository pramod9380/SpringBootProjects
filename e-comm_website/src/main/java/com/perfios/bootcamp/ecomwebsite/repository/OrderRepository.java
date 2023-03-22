package com.perfios.bootcamp.ecomwebsite.repository;

import com.perfios.bootcamp.ecomwebsite.beans.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder,Integer> {

    Optional<MyOrder> findByOrderId(String id);

}
