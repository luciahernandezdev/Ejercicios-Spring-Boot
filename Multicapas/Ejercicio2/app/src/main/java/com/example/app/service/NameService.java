package com.example.app.service;

import java.util.Collections;
import java.util.List;

public class NameService implements NameServiceInt{

    @Override
    public List<String> ordenarNombres(List<String> nombres) {
        Collections.sort(nombres);
        return nombres;
    }

}
