package com.hackaboss.App.entities;

import java.util.Arrays;
import java.util.List;

public class DatosCuriosos {
    private static List<String> datosCuriosos = Arrays.asList(
            "Los delfines tienen la capacidad de reconocer y recordar estos silbidos específicos incluso después de mucho tiempo",
            "Las hormigas son capaces de llevar objetos que son hasta 50 veces su propio peso",
            "El corazón de un camarón está en su cabeza",
            "Los koalas duermen alrededor de 22 horas al día",
            "Las estrellas de mar no tienen cerebro"
    );

    public static List<String> datosCuriosos() {
        return datosCuriosos;
    }
}
