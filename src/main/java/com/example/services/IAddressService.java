package com.example.services;

import com.example.dto.AddressDTO;

public interface IAddressService {
    public AddressDTO findAddressById(Long id);
}
