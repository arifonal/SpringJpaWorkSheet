package com.example.controller.impl;


import com.example.controller.IHomeController;
import com.example.dto.HomeDTO;
import com.example.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/home")
public class HomeControllerImpl implements IHomeController {

    @Autowired
    private IHomeService homeService;

    @GetMapping(path = "/{id}")
    @Override
    public HomeDTO findHomeById(@PathVariable(name = "id") Long id) {

        return homeService.findHomeById(id);
    }
}
