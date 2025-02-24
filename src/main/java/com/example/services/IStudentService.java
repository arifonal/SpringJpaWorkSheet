package com.example.services;

import com.example.dto.StudentDTO;
import com.example.dto.StudentDTOIU;
import com.example.entities.Student;

import java.util.List;

public interface IStudentService {

    public List<StudentDTO> getAllStudents();

    public StudentDTO getStudentById(Integer id);

    public List<StudentDTO> getStudentByName(String firstName);

    public StudentDTO saveStudent(StudentDTOIU student);

    public StudentDTO updateStudent(Integer id, StudentDTOIU studentDTOIU);

    public void deleteStudent(Integer id);

}
