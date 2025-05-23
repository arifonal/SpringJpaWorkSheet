package com.example.controller.impl;


import com.example.configuration.DataSource;
import com.example.configuration.GlobalProperties;
import com.example.configuration.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {

    @Autowired
    private GlobalProperties globalProperties;

    /*

    @GetMapping("/datasource")
    public DataSource getDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setUsername(globalProperties.getUsername());
        dataSource.setUrl(globalProperties.getUrele());
        dataSource.setPassword(globalProperties.getPassword());

        return dataSource;
    }*/


    @GetMapping(value = "/server-list")
    private List<Server> getAllServers(){
        return globalProperties.getServers();
    }

}
