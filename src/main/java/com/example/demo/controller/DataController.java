package com.example.demo.controller;

import java.util.List;

import com.example.demo.service.DataService;
import com.example.demo.service.dto.DataDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@AllArgsConstructor
public class DataController {

    private final DataService dataService;

    @GetMapping
    public List<DataDto> getAll() {
        return dataService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DataDto save(@RequestBody DataDto dto) {
        return dataService.save(dto);
    }

    @GetMapping("/{id}")
    public DataDto getById(@PathVariable Long id) {
        return dataService.getById(id);
    }

    @PutMapping("/{id}")
    public DataDto update(@PathVariable Long id, @RequestBody DataDto dto) {
        return dataService.update(dto.setId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        dataService.deleteById(id);
    }
}
