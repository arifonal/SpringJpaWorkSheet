package com.example.services;

import com.example.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEmployeeService {

    public List<EmployeeDTO> getEmployeeList();
}
