package com.example.dto;

import com.example.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeDTO {

    private Long id;

    private BigDecimal price;

    private List<RoomDTO> rooms = new ArrayList<>(); // nullpointer almamak için

}
