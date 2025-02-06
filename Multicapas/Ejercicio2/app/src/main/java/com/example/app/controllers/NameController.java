package com.example.app.controllers;

import com.example.app.service.NameServiceInt;

import java.util.List;


public class NameController {
    private final NameServiceInt nameService;

    public NameController(NameServiceInt nameService) {
        this.nameService = nameService;
    }

    @PostMapping("/ordenarNombres")
    public List<String> ordenarNombres(@RequestBody List<String> nombres) {
        return nameService.ordenarNombres(nombres);
    }
}