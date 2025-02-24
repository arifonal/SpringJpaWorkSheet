package com.example.services.impl;

import com.example.dto.HomeDTO;
import com.example.dto.RoomDTO;
import com.example.entities.Home;
import com.example.entities.Room;
import com.example.repository.HomeRepository;
import com.example.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    public HomeDTO findHomeById(Long id) {


        Optional<Home> optional = homeRepository.findById(id);

        if (optional.isPresent()) {
            Home dbHome = optional.get();
            HomeDTO homeDTO = new HomeDTO();

            BeanUtils.copyProperties(dbHome, homeDTO);

            List<Room> dbRooms = optional.get().getRoom();
            List<RoomDTO> roomDTOS = new ArrayList<>();

            if (dbRooms != null && !dbRooms.isEmpty()) {
                for (Room room : dbRooms) {

                    RoomDTO roomDTO = new RoomDTO();
                    BeanUtils.copyProperties(room, roomDTO);
                    homeDTO.getRooms().add(roomDTO);
                }
            }

            return homeDTO;

        } else {
            return null;
        }


    }

}
