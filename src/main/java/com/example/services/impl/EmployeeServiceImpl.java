package com.example.services.impl;

import com.example.dto.DepartmentDTO;
import com.example.dto.EmployeeDTO;
import com.example.entities.Department;
import com.example.entities.Employee;
import com.example.repository.EmployeeRepository;
import com.example.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getEmployeeList() {

        List<Employee> dbEmplooyeList = employeeRepository.findAll();


        if (dbEmplooyeList.isEmpty()) {
            return null;
        } else {
            List<EmployeeDTO> employeeDTOList = new ArrayList<>();

            for (Employee employee : dbEmplooyeList) {
                EmployeeDTO employeeDTO = new EmployeeDTO();

                BeanUtils.copyProperties(employee, employeeDTO);

                // Bunu da beanutils ile doldurmayı denedim başaramadık
                employeeDTO.setDepartment(new DepartmentDTO(employee.getDepartment().getId(), employee.getDepartment().getDepartmentName()));


                employeeDTOList.add(employeeDTO);
            }

            return employeeDTOList;
        }

    }
}
