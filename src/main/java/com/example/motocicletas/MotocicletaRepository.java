package com.example.motocicletas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MotocicletaRepository {
    private final Map<String, Motocicleta> baseDeDatos = new HashMap<>();

    // Guardar una motocicleta
    public Motocicleta save(Motocicleta motocicleta) {
        baseDeDatos.put(motocicleta.getId(), motocicleta);
        return motocicleta;
    }

    // Encontrar motocicleta por ID
    public Motocicleta findById(String id) {
        return baseDeDatos.get(id);
    }

    // Listar todas las motocicletas
    public List<Motocicleta> findAll() {
        return new ArrayList<>(baseDeDatos.values());
    }

    // Eliminar una motocicleta
    public void deleteById(String id) {
        baseDeDatos.remove(id);
    }

    // Actualizar las motocicletas
    public Motocicleta update(Motocicleta motocicleta) {
        if (baseDeDatos.containsKey(motocicleta.getId())) {
            baseDeDatos.put(motocicleta.getId(), motocicleta);
            return motocicleta;
        }
        return null;

    }
}
