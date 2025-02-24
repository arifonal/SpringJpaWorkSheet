package com.example.controller.impl;

import com.example.controller.IEmployeeController;
import com.example.dto.EmployeeDTO;
import com.example.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController implements IEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping(path = "/list")
    @Override
    public List<EmployeeDTO> getEmployeeList() {
        return employeeService.getEmployeeList();
    }
}
