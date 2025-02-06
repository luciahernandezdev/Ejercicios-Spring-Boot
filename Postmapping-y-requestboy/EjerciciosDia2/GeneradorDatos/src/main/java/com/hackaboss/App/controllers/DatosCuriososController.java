package com.hackaboss.App.controllers;

import com.hackaboss.App.entities.DatosCuriosos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class DatosCuriososController {

    @GetMapping("/datos")
    public String datosCurioso() {
        List<String> datosCuriosos = DatosCuriosos.datosCuriosos();
        Random random = new Random();
        int index = random.nextInt(datosCuriosos.size());
        return datosCuriosos.get(index);
    }
}
