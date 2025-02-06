package com.app.repositories;

import com.app.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadanoRepositorioInterfaz extends JpaRepository <Turno, Long> {
}
