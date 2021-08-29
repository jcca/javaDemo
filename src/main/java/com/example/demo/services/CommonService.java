package com.example.demo.services;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CommonService <T, ID> {
    Iterable<T> findAll();

    Optional<T> findById(ID id);

    T save(T t);

    void deleteById(ID id);
}
