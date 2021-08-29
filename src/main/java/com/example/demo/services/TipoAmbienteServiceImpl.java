package com.example.demo.services;

import com.example.demo.models.TipoAmbiente;
import com.example.demo.repositories.TipoAmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TipoAmbienteServiceImpl extends CommonServiceImpl<TipoAmbiente, TipoAmbienteRepository> implements TipoAmbienteService{

}
