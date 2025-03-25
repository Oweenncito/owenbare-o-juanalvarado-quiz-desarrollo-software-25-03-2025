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
       
       this.id = UUID.randomUUID().toString();
       this.marca = marca;
       this.placa = placa;
       this.cilindraje = cilindraje;
       this.precio = precio;
       this.color = color; 
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
   
}
