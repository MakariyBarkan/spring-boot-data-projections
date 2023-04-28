package com.example.demo.service;

import javax.xml.crypto.Data;
import java.util.List;

import com.example.demo.service.dto.DataDto;

public interface DataService {

    List<DataDto> findAll();

    DataDto getById(Long id);

    DataDto save(DataDto dto);

    DataDto update(DataDto dto);

    void deleteById(Long id);
}
