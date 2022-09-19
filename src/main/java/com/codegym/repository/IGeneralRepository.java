package com.codegym.repository;

import com.codegym.model.Shoes;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();

    T findById(Integer id);

    void save(Shoes t);

    void remove(Integer id);

    void update(Integer id, Shoes shoes);

}
