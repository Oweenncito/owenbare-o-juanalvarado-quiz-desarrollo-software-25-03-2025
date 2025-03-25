/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.motocicletas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class MotocicletaService {

    private final MotocicletaRepository motocicletaRepository;

    @Autowired
    public MotocicletaService(MotocicletaRepository motocicletaRepository) {
        this.motocicletaRepository = motocicletaRepository;
        initSampleData();
    }

    private void initSampleData() {
        save(new Motocicleta("Yamaha", "TBI67G", 125, 13000.0, "rojo"));
        save(new Motocicleta("Suzuki", "LEE18G", 110, 5000.0, "negro"));
        save(new Motocicleta("BMW", "JDK23H", 1000, 120000.0, "blanca"));
        save(new Motocicleta("Honda", "XYZ789", 125, 14000.0, "azul"));
    }

    public Motocicleta save(Motocicleta motocicleta) {
        return motocicletaRepository.save(motocicleta);
    }

    public Motocicleta findById(String id) {
        return motocicletaRepository.findById(id);
    }

    public List<Motocicleta> findByCilindraje(int cilindraje) {
        return motocicletaRepository.findByCilindraje(cilindraje);
    }

    public List<Motocicleta> findAll() {
        return motocicletaRepository.findAll();
    }

    public Motocicleta update(Motocicleta motocicleta) {
        return motocicletaRepository.update(motocicleta);
    }

    public void deleteById(String id) {
        motocicletaRepository.deleteById(id);
    }
}