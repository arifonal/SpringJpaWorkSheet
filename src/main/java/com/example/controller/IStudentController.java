package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.dto.StudentDTOIU;


import java.util.List;

public interface IStudentController {
    public List<StudentDTO> getAllStudents();

    public StudentDTO getStudentById(Integer id);

    public List<StudentDTO> getStudentByName(String firstName);

    public StudentDTO saveStudent(StudentDTOIU studentDTOIU);

    public StudentDTO updateStudent(Integer id, StudentDTOIU updatedStudent);

    public void deleteStudent(Integer id);
}
