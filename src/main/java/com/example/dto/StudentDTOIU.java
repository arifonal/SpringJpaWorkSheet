package com.example.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTOIU {

    @NotEmpty(message = "Firstname boş bırakılamaz")
    private String firstName;

    @NotNull(message = "LastName boş bırakılamaz")
    @Size(min = 2, max = 20)

    // Min ve Max stringde sıkıntı çıkarıyor intte kullanılıyor gibi bişeyler gördüm hata veriyordu zaten çok bakmadım commentledim şimdilik
    //@Min(2)
    //@Max(value = 20, message = "Lastname 20 karakterden uzun olamaz")
    private String lastName;

    private Date birthOfDate;

    /*@Email
    private String Email;*/
}
