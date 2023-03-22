package com.perfios.bootcamp.ecomwebsite.controller;

import com.perfios.bootcamp.ecomwebsite.beans.Address;
import com.perfios.bootcamp.ecomwebsite.beans.User;
import com.perfios.bootcamp.ecomwebsite.dto.AddressDTO;
import com.perfios.bootcamp.ecomwebsite.dto.UserDTO;
import com.perfios.bootcamp.ecomwebsite.repository.UserRepository;
import com.perfios.bootcamp.ecomwebsite.service.AddressService;
import com.perfios.bootcamp.ecomwebsite.serviceimpl.AddressServiceImpl;
import com.perfios.bootcamp.ecomwebsite.serviceimpl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {

    @Autowired
    AddressServiceImpl addressService;

    @Autowired
    UserRepository userRepository;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    @PostMapping("/address")
    public String saveAddress(@ModelAttribute("address") AddressDTO addressDTO){

        String email = MyUserDetailsService.username;
        User user = userRepository.findByEmailId(email).get();

        // Address Details

        Address address = new Address();
        address.setUser(user);
        address.setId(addressDTO.getId());
        address.setFirstName(addressDTO.getFirstName());
        address.setLastName(addressDTO.getLastName());
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.getAddressLine2());
        address.setPincode(addressDTO.getPincode());
        address.setCity(addressDTO.getCity());
        address.setEmail(addressDTO.getEmail());
        address.setMobileNumber(addressDTO.getMobileNumber());

        addressService.saveAddress(address);

        System.out.println("address controller is called!!!");
        System.out.println("Address: "+addressDTO);
        System.out.println("email:"+email);
        return "index";
    }
}
