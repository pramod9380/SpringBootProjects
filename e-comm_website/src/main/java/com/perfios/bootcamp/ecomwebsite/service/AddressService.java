package com.perfios.bootcamp.ecomwebsite.service;

import com.perfios.bootcamp.ecomwebsite.beans.Address;
import com.perfios.bootcamp.ecomwebsite.dto.AddressDTO;
import com.perfios.bootcamp.ecomwebsite.exception.AddressNotFoundException;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddresses();
    void saveAddress(Address address);
    Address getAddressById(int id) throws AddressNotFoundException;
    void deleteAddressById(int id) throws AddressNotFoundException;
    List<Address> findAllAddressesByUserId(int id);


}
