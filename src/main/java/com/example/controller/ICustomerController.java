package com.example.controller;

import com.example.dto.CustomerDTO;

public interface ICustomerController {
    public CustomerDTO findCustomerById(Long id);

}
