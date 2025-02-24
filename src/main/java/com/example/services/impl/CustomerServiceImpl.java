package com.example.services.impl;

import com.example.dto.AddressDTO;
import com.example.dto.CustomerDTO;
import com.example.entities.Address;
import com.example.entities.Customer;
import com.example.repository.CustomerRepository;
import com.example.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO findCustomerById(Long id) {
       Optional<Customer> optional = customerRepository.findById(id);

        AddressDTO addressDTO = new AddressDTO();
        CustomerDTO customerDTO = new CustomerDTO();

       if (optional.isPresent()){
           Customer customer = optional.get();
           Address address = optional.get().getAddress();

           BeanUtils.copyProperties(customer, customerDTO);
           BeanUtils.copyProperties(address, addressDTO);

           customerDTO.setAddress(addressDTO);

           return customerDTO;
       }else {
           return null;
       }
    }
}
