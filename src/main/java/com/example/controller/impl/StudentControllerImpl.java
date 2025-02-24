package com.example.controller.impl;

import com.example.controller.IStudentController;
import com.example.dto.StudentDTO;
import com.example.dto.StudentDTOIU;
import com.example.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("rest/api/student")
public class StudentControllerImpl implements IStudentController {


    // Interface ile implemente ettik genel kullanım böleymiş
    @Autowired // bunu eklemeyi unutma
    private IStudentService studentService;



    @GetMapping(path = "/view-all")
    @Override
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public StudentDTO getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping(path = "/list/name/{firstName}")
    @Override
    public List<StudentDTO> getStudentByName(@PathVariable(name = "firstName") String firstName) {
        return studentService.getStudentByName(firstName);
    }

    @PostMapping(path = "/save")
    @Override // @Valid anotasyonu kullandık yazdığımız anotasyonların çalışması için
    public StudentDTO saveStudent(@RequestBody @Valid StudentDTOIU studentDTOIU) { // Normalde böyle doğrudan entity dönülmez tehlikelidir Dto dönülür ama şimdilik geçtik
        return studentService.saveStudent(studentDTOIU);
    }


    @PutMapping(path = "/update/{id}")
    @Override
    public StudentDTO updateStudent(@PathVariable(name = "id") Integer id, @RequestBody StudentDTOIU studentDTOIU) {
        return studentService.updateStudent(id, studentDTOIU);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudent(id);
    }


}
