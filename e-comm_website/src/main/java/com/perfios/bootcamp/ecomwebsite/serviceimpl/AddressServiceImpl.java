package com.perfios.bootcamp.ecomwebsite.serviceimpl;

import com.perfios.bootcamp.ecomwebsite.beans.Address;
import com.perfios.bootcamp.ecomwebsite.exception.AddressNotFoundException;
import com.perfios.bootcamp.ecomwebsite.repository.AddressRepository;
import com.perfios.bootcamp.ecomwebsite.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address getAddressById(int id) throws AddressNotFoundException {
        addressRepository.findById(id).orElseThrow(()-> new AddressNotFoundException("Address Not Found With this id, Please Enter valid Address id"));
        return addressRepository.findById(id).get();
    }

    @Override
    public void deleteAddressById(int id) throws AddressNotFoundException {
        addressRepository.findById(id).orElseThrow(()-> new AddressNotFoundException("Address Not Found With this id, Please Enter valid Address id"));
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findAllAddressesByUserId(int id) {
        return addressRepository.findAllAddressesByUserId(id);
    }
}
