package com.example.controller.impl;


import com.example.controller.IAddressController;
import com.example.dto.AddressDTO;
import com.example.services.IAddressService;
import com.example.services.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl implements IAddressController {

    @Autowired
    private IAddressService addressService;

    @GetMapping(path = "/list/{id}")
    @Override
    public AddressDTO findAddressById(@PathVariable(name = "id") Long id) {

        return addressService.findAddressById(id);
    }
}
