package com.example.demo.controllers;

import com.example.demo.models.Restaurante;
import com.example.demo.models.RestauranteAmbiente;
import com.example.demo.models.TipoAmbiente;
import com.example.demo.models.TipoComida;
import com.example.demo.repositories.RestauranteAmbienteRepository;
import com.example.demo.services.RestauranteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController extends CommonController<Restaurante, RestauranteService>{
    Logger logger = LoggerFactory.getLogger(RestauranteController.class);
    @Autowired
    RestauranteAmbienteRepository repositoryRA;
    @PutMapping("/{id}")
    public ResponseEntity editar(@RequestBody Restaurante restaurante, @PathVariable Long id) {
        var o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Restaurante entity = o.get();
        restaurante.setId(entity.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(restaurante));
    }

    @PutMapping("/{id}/asignar-comidas")
    public ResponseEntity asignarTipoComidas(@RequestBody List<TipoComida> tipoComidas, @PathVariable Long id) {
        var o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Restaurante entity = o.get();
        tipoComidas.forEach(entity.getComidas()::add);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @PutMapping("/{id}/asignar-ambientes")
    @Transactional
    public ResponseEntity asignarAmbientes(@RequestBody List<TipoAmbiente> tipoAmbientes, @PathVariable Long id) {
        var o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Restaurante entity = o.get();
        tipoAmbientes.forEach(tipoAmbiente -> {
            System.out.println(tipoAmbiente.getId());
            RestauranteAmbiente ra = new RestauranteAmbiente();
            ra.setRestaurante(entity);
            ra.setTipoAmbiente(tipoAmbiente);
            ra.setGrade(20);
            repositoryRA.save(ra);
            /*entity.getRestauranteAmbientes().add(ra);*/
        });
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

}
