//Rodolfo Gonzales
package com.example.soporte_tecnico.service;



import com.example.soporte_tecnico.model.Solicitud;
import java.util.List;
import java.util.Optional;

public interface SolicitudService {
    
    Solicitud guardar(Solicitud solicitud);
    
    List<Solicitud> buscarTodas();
    
    Optional<Solicitud> buscarPorId(Long id);
    
    Solicitud actualizar(Long id, Solicitud solicitudActualizada);
    
    void eliminar(Long id);
}
