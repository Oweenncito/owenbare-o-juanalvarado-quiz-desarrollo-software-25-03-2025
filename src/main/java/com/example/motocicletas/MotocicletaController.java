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

    @GetMapping
    public ResponseEntity<List<Motocicleta>> getAllMotocicletas() {
        List<Motocicleta> motocicletas = motocicletaService.findAll();
        return new ResponseEntity<>(motocicletas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motocicleta> getMotocicletaById(@PathVariable String id) {
        Motocicleta motocicleta = motocicletaService.findById(id);
        return motocicleta != null ? new ResponseEntity<>(motocicleta, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Nueva ruta para buscar por cilindraje
    @GetMapping("/cilindraje/{cilindraje}")
    public ResponseEntity<List<Motocicleta>> getMotocicletasByCilindraje(@PathVariable int cilindraje) {
        List<Motocicleta> motocicletas = motocicletaService.findByCilindraje(cilindraje);
        return motocicletas.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(motocicletas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Motocicleta> createUsuario(@RequestBody Motocicleta motocicleta) {
        Motocicleta newMotocicleta = motocicletaService.save(motocicleta);
        return new ResponseEntity<>(newMotocicleta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motocicleta> updateMotocicleta(@PathVariable String id, @RequestBody Motocicleta motocicleta) {
        Motocicleta existingMotocicleta = motocicletaService.findById(id);
        if (existingMotocicleta != null) {
            motocicleta.setId(id);
            Motocicleta updatedMotocicleta = motocicletaService.update(motocicleta);
            return new ResponseEntity<>(updatedMotocicleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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
