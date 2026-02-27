package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.demo.models.Nota;
import com.example.demo.service.NotaService;

@RestController
@RequestMapping("/api/Notas")
@CrossOrigin(origins = "*")
public class NotaController {

        private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping
    public List<Nota> listarNotas() {
        return notaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Nota obtenerNota(@PathVariable Long id) {
        return notaService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Nota no encontrada"));
    }

    @PostMapping
    public Nota crearNota(@RequestBody Nota nota) {
        return notaService.crearNota(nota);
    }

    @PutMapping("/{id}")
    public Nota actualizarNota(@PathVariable Long id, @RequestBody Nota nota) {
        return notaService.actualizarNota(id, nota);
    }

    @DeleteMapping("/{id}")
    public void eliminarNota(@PathVariable Long id) {
        notaService.eliminarNota(id);
    }
    
}
