package com.example.demo.controllers;

import com.example.demo.models.TipoComida;
import com.example.demo.services.TipoComidaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comidas")
public class TipoComidaController extends CommonController<TipoComida, TipoComidaService> {
    @PutMapping("/{id}")
    public ResponseEntity editar(@RequestBody TipoComida tipoComida, @PathVariable Long id) {
        var o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tipoComida.setId(o.get().getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tipoComida));
    }
}
