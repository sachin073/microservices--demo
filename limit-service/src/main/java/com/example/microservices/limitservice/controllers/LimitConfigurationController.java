package com.example.microservices.limitservice.controllers;

import com.example.microservices.limitservice.config.LoadConfiguration;
import com.example.microservices.limitservice.modals.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sachin on 1/7/18.
 */

@RestController
public class LimitConfigurationController {


    @Autowired
    LoadConfiguration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitConfiguration(){
        return new LimitConfiguration(configuration.getMax(),configuration.getMin());
    }


}
