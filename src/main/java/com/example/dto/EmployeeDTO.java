package com.example.dto;

import com.example.entities.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {


    private Long id;

    private String name;

    private DepartmentDTO department;
}
