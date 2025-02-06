package com.hackaboss.App.controllers;

import com.hackaboss.App.entities.Refranes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class RefranController {

    @GetMapping("/refranes")
    public String getRefran() {
        List<String> refranes = Refranes.getRefranes();
        Random random = new Random();
        int index = random.nextInt(refranes.size());
        return refranes.get(index);
    }
}
