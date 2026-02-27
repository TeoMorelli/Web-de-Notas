package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demo.repository.NotaRepository;

import com.example.demo.models.Nota;
import com.example.demo.repository.NotaRepository;


@Service
public class NotaService {
    
    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public List<Nota> obtenerTodas() {
        return notaRepository.findAll();
    }

    public Optional<Nota> obtenerPorId(Long id) {
        return notaRepository.findById(id);
    }

    public Nota crearNota(Nota nota) {
        nota.setFechaActualizacion(null);
        return notaRepository.save(nota);
    }

    public Nota actualizarNota(Long id, Nota nuevaNota) {
        return notaRepository.findById(id).map(nota -> {
            nota.setTitulo(nuevaNota.getTitulo());
            nota.setContenido(nuevaNota.getContenido());
            nota.setFechaActualizacion(LocalDateTime.now());
            return notaRepository.save(nota);
        }).orElseThrow(() -> new RuntimeException("Nota no encontrada"));
    }

    public void eliminarNota(Long id) {
        notaRepository.deleteById(id);
    }

}
