package com.example.repository;


import com.example.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CourseRepository extends JpaRepository<Course, Long> { }
