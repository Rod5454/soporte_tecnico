package com.example.soporte_tecnico.service;


import com.example.soporte_tecnico.exception.SolicitudNotFoundException;
import com.example.soporte_tecnico.model.Cliente;
import com.example.soporte_tecnico.model.Solicitud;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private final Map<Long, Solicitud> inventarioSolicitudes = new HashMap<>();
    private Long nextId = 1L;

    public SolicitudServiceImpl() {
        precargarDatos();
    }

    private void precargarDatos() {
        Cliente cliente1 = new Cliente("Rodolfo Gonzales", "rodolfo.g@tech.com");
        Cliente cliente2 = new Cliente("Marco Suares", "marco.s@tech.com");
        Cliente cliente3 = new Cliente("Carlos Garcia", "carlos.g@tech.com");

        guardar(new Solicitud(null, "Fallo de conexión a internet", "No puedo acceder a internet en mi pc, ya se hizo varios metodos para arreglarlo.", cliente1, 5));
        guardar(new Solicitud(null, "Problema con la pc", "La pc se apaga cada 30 minutos.", cliente2, 2));
        guardar(new Solicitud(null, "Fallo de instalacion en drivers", "No me deja instalar los drivers nesesarios.", cliente3, 1));
    }


    @Override
    public Solicitud guardar(Solicitud solicitud) {
        solicitud.setId(nextId++);
        inventarioSolicitudes.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    @Override
    public List<Solicitud> buscarTodas() {
        return new ArrayList<>(inventarioSolicitudes.values());
    }

    @Override
    public Optional<Solicitud> buscarPorId(Long id) {
        return Optional.ofNullable(inventarioSolicitudes.get(id));
    }

    @Override
    public Solicitud actualizar(Long id, Solicitud solicitudActualizada) {
        if (!inventarioSolicitudes.containsKey(id)) {
            throw new SolicitudNotFoundException("Solicitud con ID " + id + " no encontrada.");
        }
        
        solicitudActualizada.setId(id); 
        
        inventarioSolicitudes.put(id, solicitudActualizada);
        return solicitudActualizada;
    }

    @Override
    public void eliminar(Long id) {
        if (inventarioSolicitudes.remove(id) == null) {
            throw new SolicitudNotFoundException("Solicitud con ID " + id + " no encontrada para eliminar.");
        }
    }
}