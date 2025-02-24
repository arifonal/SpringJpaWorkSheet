package com.example.configuration;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/*@Data
@Component*/
@ConfigurationProperties(prefix = "app")
@Data
@Component
public class GlobalProperties {

/*    @Value("${spring.datasource.url}")
    private String urele;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;*/



    private List<Server> servers;








}
