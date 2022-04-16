package com.example.ApiRestClinica.mvc.repository;

import com.example.ApiRestClinica.model.Odontologo;
import com.example.ApiRestClinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

}
