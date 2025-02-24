package com.example.controller;

import com.example.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeController {
    public List<EmployeeDTO> getEmployeeList();
}
