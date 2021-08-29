package com.example.demo.controllers;

import com.example.demo.models.TipoAmbiente;
import com.example.demo.models.TipoComida;
import com.example.demo.services.TipoAmbienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ambientes")
public class TipoAmbienteController extends CommonController<TipoAmbiente, TipoAmbienteService> {
    @PutMapping("/{id}")
    public ResponseEntity editar(@RequestBody TipoAmbiente tipoAmbiente, @PathVariable Long id) {
        var o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tipoAmbiente.setId(o.get().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tipoAmbiente));
    }
}
