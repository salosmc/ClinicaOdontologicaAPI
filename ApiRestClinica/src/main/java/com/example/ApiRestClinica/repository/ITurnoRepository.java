package com.example.ApiRestClinica.repository;

import com.example.ApiRestClinica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno,Long> {
}
