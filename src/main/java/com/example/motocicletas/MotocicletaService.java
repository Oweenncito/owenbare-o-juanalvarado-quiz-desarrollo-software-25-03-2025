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
     
     public MotocicletaService(MotocicletaRepository motocicletaRepository){
       
         this.motocicletaRepository = motocicletaRepository;
         initSampleData ();
     }
       private void initSampleData() {
        save(new Motocicleta("Yamaha", "TBI67G", 125, 13.000000,"rojo"));
        save ( new Motocicleta ("susuzi", "LEE18G", 110, 5.000000, "negro"));
        save ( new Motocicleta ("bmw", "JDK23H", 1000, 120.000000, "blanca"));
    }

         public Motocicleta save(Motocicleta motocicleta) {
        return motocicletaRepository.save(motocicleta);
    }
             public Motocicleta findById(String id) {
        return  motocicletaRepository.findById(id);
    }
    
    // Listar todos los usuarios
    public List<Motocicleta> findAll() {
        return motocicletaRepository.findAll();
    }
    
    // Actualizar un usuario
    public Motocicleta pdate(Motocicleta motocicleta) {
        return motocicletaRepository.update(motocicleta);
    }
    
    // Eliminar un usuario
    public void deleteById(String id) {
        motocicletaRepository.deleteById(id);
    }
    
}
