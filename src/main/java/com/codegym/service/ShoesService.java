package com.codegym.service;

import com.codegym.model.Shoes;
import com.codegym.repository.IGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoesService implements IShoesService {

    @Autowired
    private IGeneralRepository shoesRepository;

    @Override
    public List<Shoes> findAll() {
        return shoesRepository.findAll();
    }

    @Override
    public Shoes findById(Integer id) {
        return (Shoes) shoesRepository.findById(id);
    }

    @Override
    public void save(Shoes shoes) {

    }


    @Override
    public void remove(Integer id) {
        shoesRepository.remove(id);
    }

    @Override
    public void update(Integer id, Shoes shoes) {

    }

}