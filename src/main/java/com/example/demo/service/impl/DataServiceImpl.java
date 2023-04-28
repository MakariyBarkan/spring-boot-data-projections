package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.repository.DataRepository;
import com.example.demo.service.DataService;
import com.example.demo.service.dto.DataDto;
import com.example.demo.service.exception.NotFoundException;
import com.example.demo.service.mapper.DataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    private final DataMapper dataMapper;

    @Override
    public List<DataDto> findAll() {
        return dataRepository.findAll().stream()
                .map(dataMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DataDto getById(Long id) {
        return dataRepository.findById(id).map(dataMapper::toDto)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public DataDto save(DataDto dto) {
        return saveOrUpdate(dto);
    }

    @Override
    public DataDto update(DataDto dto) {
        if (!dataRepository.existsById(dto.getId())) {
            throw new NotFoundException(dto.getId());
        }
        return saveOrUpdate(dto);
    }

    @Override
    public void deleteById(Long id) {
        if (!dataRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        dataRepository.deleteById(id);
    }

    private DataDto saveOrUpdate(DataDto dto) {
        return dataMapper.toDto(dataRepository.save(dataMapper.toEntity(dto)));
    }
}
