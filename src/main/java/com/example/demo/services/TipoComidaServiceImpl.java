package com.example.demo.services;

import com.example.demo.models.TipoComida;
import com.example.demo.repositories.TipoComidaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoComidaServiceImpl extends CommonServiceImpl<TipoComida, TipoComidaRepository> implements TipoComidaService {
}
