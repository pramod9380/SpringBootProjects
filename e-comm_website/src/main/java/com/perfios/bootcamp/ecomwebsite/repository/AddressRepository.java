package com.perfios.bootcamp.ecomwebsite.repository;

import com.perfios.bootcamp.ecomwebsite.beans.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    List<Address> findAllAddressesByUserId(int id);
}
