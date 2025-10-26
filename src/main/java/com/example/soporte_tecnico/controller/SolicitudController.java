package com.example.soporte_tecnico.controller;

import com.example.soporte_tecnico.exception.SolicitudNotFoundException;
import com.example.soporte_tecnico.model.Solicitud;
import com.example.soporte_tecnico.service.SolicitudService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/solicitudes") 
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping
    public ResponseEntity<Solicitud> guardarSolicitud(@Valid @RequestBody Solicitud solicitud) {
        Solicitud nuevaSolicitud = solicitudService.guardar(solicitud);
        return new ResponseEntity<>(nuevaSolicitud, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Solicitud>> buscarTodas() {
        List<Solicitud> solicitudes = solicitudService.buscarTodas();
        return new ResponseEntity<>(solicitudes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> buscarPorId(@PathVariable Long id) {
        Solicitud solicitud = solicitudService.buscarPorId(id)
                .orElseThrow(() -> new SolicitudNotFoundException("Solicitud de soporte con ID " + id + " no encontrada."));
        return new ResponseEntity<>(solicitud, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizarSolicitud(@PathVariable Long id, @Valid @RequestBody Solicitud solicitudActualizada) {
        Solicitud solicitudEditada = solicitudService.actualizar(id, solicitudActualizada);
        return new ResponseEntity<>(solicitudEditada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {
        solicitudService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}