package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Nota;

public interface NotaRepository  extends JpaRepository<Nota, Long>{
    /* Genera por si solo los metodos findAll, findById, save y deleteById */
}
