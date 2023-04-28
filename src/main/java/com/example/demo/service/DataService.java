package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.DataDto;

public interface DataService {

    List<DataDto> findAll();

    DataDto getById(Long id);

    void save(DataDto dto);

    void update(DataDto dto);

    void deleteById(Long id);
}
