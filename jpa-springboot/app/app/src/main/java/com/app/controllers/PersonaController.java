package com.app.controllers;

import com.app.entities.Persona;
import com.app.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService personaServ;

    @GetMapping("/traer")
    public List<Persona> getPersonas() {
        return personaServ.getPersonas();
    }

    @PostMapping("/crear")
    public String savePersona(@RequestBody Persona perso) {
        personaServ.savePersona(perso);
        return "Persona creada correctamente";
    }

    @DeleteMapping ("/borrar/{id}")
    public String deletePersona (@PathVariable Long id) {
        personaServ.deletePersona(id);
        return "Persona eliminada correctamente";
    }

    //para hacer un "update" (edición) Hibernate no cuenta con un método específico
    // (como si lo hacía Eclipselink). Por lo que es necesario, buscar la persona
    // a editar, setear sus nuevos valores a nivel lógico y luego enviarlos a la BD
    // mediante el método Save. Recordemos que save es "guardar" por lo que sirve
    // tanto para altas como para modificaciones ya que "guarda" los datos.

    @PutMapping ("/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam ("nombre") String nombreModif,
                                @RequestParam ("apellido") String apellidoModif,
                                @RequestParam ("edad") int edadModif
                                ){

      //buscamos la persona en cuestión
        Persona perso = personaServ.findPersona(id);

        perso.setNombre(nombreModif);
        perso.setApellido(apellidoModif);
        perso.setEdad(edadModif);

        personaServ.savePersona(perso);

        return perso;

    }   }