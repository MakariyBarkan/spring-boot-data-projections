package com.example.demo.service.mapper;

import com.example.demo.domain.DataEntity;
import com.example.demo.service.dto.DataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper {

    DataEntity toEntity(DataDto dto);

    DataDto toDto(DataEntity entity);
}
