package com.hackaboss.App.entities;

import java.util.Arrays;
import java.util.List;

public class DatosCuriosos {
    private int id;
    private String datosCurioso;

    public DatosCuriosos(int id, String datosCurioso) {
        this.id = id;
        this.datosCurioso = datosCurioso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatosCurioso() {
        return datosCurioso;
    }

    public void setDatosCurioso(String datosCurioso) {
        this.datosCurioso = datosCurioso;
    }

    @Override
    public String toString() {
        return "DatosCuriosos{" +
                "id=" + id +
                ", datosCurioso='" + datosCurioso + '\'' +
                '}';
    }

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
}
