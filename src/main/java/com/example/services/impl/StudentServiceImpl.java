package com.example.services.impl;

import com.example.dto.CourseDTO;
import com.example.dto.StudentDTO;
import com.example.dto.StudentDTOIU;
import com.example.entities.Course;
import com.example.entities.Student;
import com.example.repository.StudentRepository;
import com.example.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*

Eskiler DTO kullanılmadan yazıldı comment içindekiler, o yüzden student dönüyor yada alıyorlar

Onları değiştirmekle uğraşmadım
 */

@Service
public class StudentServiceImpl implements IStudentService {

    // repository işaretlediğimiz için beani oluşmuştu burda o beana ulaştık autowired ile
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> dtoList = new ArrayList<>();

        List<Student> studentList = studentRepository.findAllStudentsAsNative(); // kendi yazdığımız query methodu
        for (Student student: studentList){
            StudentDTO dto = new StudentDTO();
            BeanUtils.copyProperties(student, dto);
            dtoList.add(dto);
        }
        return dtoList;

    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        StudentDTO studentDTO = new StudentDTO();

        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()){
            Student dbStudent = optional.get();
            BeanUtils.copyProperties(dbStudent,studentDTO);

            if (!dbStudent.getCourses().isEmpty() && dbStudent.getCourses()!=null){

                for (Course course : dbStudent.getCourses()){
                    CourseDTO courseDTO = new CourseDTO();
                    BeanUtils.copyProperties(course, courseDTO);

                    studentDTO.getCourses().add(courseDTO);

                }



            }




        }
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getStudentByName(String firstName) {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllStudentsAsNative();

        for (Student student : studentList){
            if (student.getFirstName().equalsIgnoreCase(firstName)){
                StudentDTO dto = new StudentDTO();
                BeanUtils.copyProperties(student, dto);
                studentDTOS.add(dto);
            }
        }

        return studentDTOS;
    }


/*    @Override       // Üsttekine kısa alternatif
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }*/


    @Override
    public StudentDTO saveStudent(StudentDTOIU studentDTOIU) {
        /*if (student.getFirstName() == null || student.getLastName() == null) {
            throw new IllegalArgumentException("First name and last name cannot be null");
        }
        //return studentRepository.save(student);*/

        StudentDTO response = new StudentDTO();
        Student student = new Student();
        BeanUtils.copyProperties(studentDTOIU, student); // Tek tek getlerle alıp setlerle setlemekten kurtarır otomatik yapar

        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }


    @Override
    public StudentDTO updateStudent(Integer id, StudentDTOIU studentDTOIU) {
        StudentDTO studentDTO = new StudentDTO();

        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()){ // buraya girmiyor bunu çöz
            Student dbStudent = optional.get();

            dbStudent.setFirstName(studentDTOIU.getFirstName());
            dbStudent.setLastName(studentDTOIU.getLastName());
            dbStudent.setBirthOfDate(studentDTOIU.getBirthOfDate());

            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent, studentDTO);
            return studentDTO;
        }
        return null;
    }




    public void deleteStudent(Integer id){
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()){
            studentRepository.delete(optional.get());
        }

    }


}
