package com.example.services.impl;

import com.example.dto.AddressDTO;
import com.example.dto.CustomerDTO;
import com.example.entities.Address;
import com.example.entities.Customer;
import com.example.repository.AddressRepository;
import com.example.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public AddressDTO findAddressById(Long id) {
        Optional<Address> optional = addressRepository.findById(id);

        if (optional.isPresent()) {
            AddressDTO addressDTO = new AddressDTO();
            Address address = optional.get();

            BeanUtils.copyProperties(address, addressDTO);

            CustomerDTO customerDTO = new CustomerDTO();

            customerDTO.setName(address.getCustomer().getName());
            customerDTO.setId(address.getCustomer().getId());

            // bu sonsuz döngüye sebep oldu address 2 kez set edilmeye çalışıldığı için sanırım
            // customerDTO.setAddress(addressDTO);


             addressDTO.setCustomer(customerDTO);

            return addressDTO;
        } else {
            return null;
        }
    }
}
