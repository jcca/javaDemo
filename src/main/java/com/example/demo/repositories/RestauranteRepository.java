package com.example.demo.repositories;

import com.example.demo.models.Restaurante;
import org.springframework.data.repository.CrudRepository;

public interface RestauranteRepository extends CrudRepository<Restaurante, Long> {
}
