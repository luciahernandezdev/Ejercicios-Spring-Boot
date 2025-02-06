package com.app.services;

import com.app.entities.Persona;
import com.app.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas () {

        return persoRepo.findAll();

    }

    @Override
    public void savePersona(Persona perso) {
        persoRepo.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {

        //acá si no encuentro a la persona, devuelvo null. Esto lo indica el orElse.
        return persoRepo.findById(id).orElse(null);

    }

}
