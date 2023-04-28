package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.domain.DataDto;
import com.example.demo.repository.DataRepository;
import com.example.demo.service.DataService;
import com.example.demo.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    @Override
    public List<DataDto> findAll() {
        return dataRepository.findAll();
    }

    @Override
    public DataDto getById(Long id) {
        return dataRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public void save(DataDto dto) {
        dataRepository.save(dto.getId(), dto.getPayload());
    }

    @Override
    public void update(DataDto dto) {
        if (!dataRepository.existsById(dto.getId())) {
            throw new NotFoundException(dto.getId());
        }
        dataRepository.update(dto.getId(), dto.getPayload());
    }

    @Override
    public void deleteById(Long id) {
        if (!dataRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        dataRepository.deleteById(id);
    }
}
