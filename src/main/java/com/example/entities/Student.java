package com.example.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
//@Getter
//@Setter
@Data // Getter ve setter eklemek yerine direk birleşimi Data yı ekledim
// Not: Bende çalışmadı hata verdi o yüzden onu geçip getter settera döndüm
// Sonra düzeldi geri buna döndüm :D
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // otomatik olarak birer birere arttırır
    private Integer id;

    @Column(name = "first_name", nullable = false) // _ kullanımı bir kalıpmış
    private String firstName;

    @Column(name = "last_name", nullable = false) // default true
    private String lastName;

    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) buda alttakiyle aynı işi yaparmış
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_of_date", nullable = true)
    private Date birthOfDate;


    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;




}
