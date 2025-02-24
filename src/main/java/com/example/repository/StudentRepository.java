package com.example.repository;

import com.example.dto.StudentDTO;
import com.example.entities.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> { // Student crud işlemleri yapacağımız table, Integer ise onun primary key işaretlenen elemanının tipi, jpa buraya göre anlayacak findAllById falan yapınca neye göre ilerleyeceğini

    // Bu kısıma jpa içindeki hazır queryler yetmediğinde aşağıdaki örnekte olduğu gibi kendi sorgularımız yazabiliriz


    // Sorguyu HQL ile yazarız (hibernate query language), dbdeki tablo ve colonların isimleriyle değilde class ismi ve değişken ismiyle yazarız
    @Query(value = "from Student", nativeQuery = false)
    List<Student> findAllStudents();

    // burda native SQL yazdık, student.student demenin amacı şema ismi . tablo ismi olarak tabloyu belirtmek
    @Query(value = "select * from student.student", nativeQuery = true)
    List<Student> findAllStudentsAsNative();


    @Query(value = "from Student s WHERE s.firstName= :firstName")
    List<Student> getStudentByName(String firstName);

}
