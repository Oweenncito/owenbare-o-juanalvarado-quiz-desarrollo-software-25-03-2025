package com.example.motocicletas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MotocicletaRepository {
    private final Map<String, Motocicleta> baseDeDatos = new HashMap<>();

    // Buscar motocicletas por cilindraje
    public List<Motocicleta> findByCilindraje(int cilindraje) {
        List<Motocicleta> resultado = new ArrayList<>();
        for (Motocicleta moto : baseDeDatos.values()) {
            if (moto.getCilindraje() == cilindraje) {
                resultado.add(moto);
            }
        }
        return resultado;
    }
        public Motocicleta findByPlaca(String placa) {
        return baseDeDatos.values().stream()
                .filter(moto -> moto.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    public Motocicleta save(Motocicleta motocicleta) {
        baseDeDatos.put(motocicleta.getId(), motocicleta);
        return motocicleta;
    }

    public Motocicleta findById(String id) {
        return baseDeDatos.get(id);
    }

    public List<Motocicleta> findAll() {
        return new ArrayList<>(baseDeDatos.values());
    }

    public void deleteById(String id) {
        baseDeDatos.remove(id);
    }

    public Motocicleta update(Motocicleta motocicleta) {
        if (baseDeDatos.containsKey(motocicleta.getId())) {
            baseDeDatos.put(motocicleta.getId(), motocicleta);
            return motocicleta;
        }
        return null;
    }
}