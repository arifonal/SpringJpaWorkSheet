package com.example.controller;


import com.example.dto.AddressDTO;

public interface IAddressController {
    public AddressDTO findAddressById(Long id);
}
