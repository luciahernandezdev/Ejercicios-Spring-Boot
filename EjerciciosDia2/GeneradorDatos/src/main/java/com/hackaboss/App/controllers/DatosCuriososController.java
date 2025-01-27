package com.hackaboss.App.controllers;

import com.hackaboss.App.entities.DatosCuriosos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class DatosCuriososController {
    private static List<DatosCuriosos> datosCuriosos = Arrays.asList(
            new DatosCuriosos(1, "Los delfines tienen la capacidad de reconocer y recordar estos silbidos específicos incluso después de mucho tiempo"),
            new DatosCuriosos(2, "Las hormigas son capaces de llevar objetos que son hasta 50 veces su propio peso"),
            new DatosCuriosos(3, "El corazón de un camarón está en su cabeza"),
            new DatosCuriosos(4, "Los koalas duermen alrededor de 22 horas al día"),
            new DatosCuriosos(5, "Las estrellas de mar no tienen cerebro")
    );

    public static List<DatosCuriosos> getDatosCuriosos() {
        return datosCuriosos;
    }

    @GetMapping("/datos")
    public DatosCuriosos getDatosCurioso() {
        List<DatosCuriosos> datosCuriosos = DatosCuriosos.getDatosCuriosos();
        Random random = new Random();
        int index = random.nextInt(datosCuriosos.size());
        return datosCuriosos.get(index);
    }
}
