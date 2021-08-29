package com.example.demo.services;

import com.example.demo.models.Restaurante;
import com.example.demo.repositories.RestauranteRepository;
import org.springframework.stereotype.Service;

@Service
public class RestauranteServiceImpl extends CommonServiceImpl<Restaurante, RestauranteRepository> implements RestauranteService{
}
