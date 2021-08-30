package com.example.demo.controllers;

import com.example.demo.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class CommonController<E, S extends CommonService<E, Long>> {

    @Autowired
    S service;

    @GetMapping
    public ResponseEntity listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity ver(@PathVariable Long id) {
        var o = service.findById(id);
        return o.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(o.get());
    }
    @PostMapping
    public ResponseEntity crear(@Valid @RequestBody E o) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(o));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
