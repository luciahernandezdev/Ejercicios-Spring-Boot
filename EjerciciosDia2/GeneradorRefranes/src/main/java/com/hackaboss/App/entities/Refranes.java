package com.hackaboss.App.entities;

import java.util.Arrays;
import java.util.List;

public class Refranes {
    private static List<String> refranes = Arrays.asList(
            "No hay mal que por bien no venga",
            "Al que madruga Dios lo ayuda",
            "Más vale tarde que nunca",
            "A quien buen árbol se arrima, buena sombra le cobija",
            "En boca cerrada no entran moscas"
    );

    public static List<String> getRefranes() {
        return refranes;
    }
}
