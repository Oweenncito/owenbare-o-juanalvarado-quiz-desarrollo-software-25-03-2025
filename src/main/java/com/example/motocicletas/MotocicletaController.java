package com.example.motocicletas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motocicletas")
public class MotocicletaController {
    private final MotocicletaService motocicletaService;
    @Autowired
    public MotocicletaController(MotocicletaService motocicletaService) {
        this.motocicletaService = motocicletaService;
    }
    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Motocicleta>> getAllMotocicletas() {
        List<Motocicleta> usuarios = motocicletaService.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Motocicleta> getMotocicletaById(@PathVariable String id) {
        Motocicleta motocicleta = motocicletaService.findById(id);
        if (motocicleta != null) {
            return new ResponseEntity<>(motocicleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Motocicleta> createUsuario(@RequestBody Motocicleta motocicleta) {
        Motocicleta newMotocicleta = motocicletaService.save(motocicleta);
        return new ResponseEntity<>(newMotocicleta, HttpStatus.CREATED);
    }
    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Motocicleta> updateMotocicleta(@PathVariable String id, @RequestBody
    Motocicleta motocicleta) {
        Motocicleta existingMotocicleta = motocicletaService.findById(id);
        if (existingMotocicleta != null) {
            motocicleta.setId(id);
            Motocicleta updatedMotocicleta = motocicletaService.pdate(motocicleta);
            return new ResponseEntity<>(updatedMotocicleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotocicleta(@PathVariable String id) {
        Motocicleta existingMotocicleta = motocicletaService.findById(id);
        if (existingMotocicleta != null) {
            motocicletaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

