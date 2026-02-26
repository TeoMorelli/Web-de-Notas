package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.NotaRepository;

import com.example.demo.models.Nota;
import com.example.demo.repository.NotaRepository;


@Service
public class NotaService {
    
    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {

    }
}
