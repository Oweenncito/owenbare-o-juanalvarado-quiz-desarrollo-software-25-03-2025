/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.motocicletas;

import java.util.UUID;
import lombok.Data;

/**
 *
 * @author PC
 */
@Data
public class Motocicleta {
    
    private String id;
    private String marca;
    private String placa;
    private int cilindraje; 
    private double precio;
    private String color; 
    
    
   public Motocicleta (){
       
       this.id = UUID.randomUUID().toString();
   }
   
   
   public Motocicleta (String marca, String placa, int cilindraje, double precio, String color){
       
       this.id = id;
       this.marca = marca;
       this.placa = placa;
       this.cilindraje = cilindraje;
       this.precio = precio;
       this.color = color; 
   }
}
