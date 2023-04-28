package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.AbstractEntity;
import com.example.demo.domain.DataDto;
import com.example.demo.repository.rowmapper.DataDtoRowMapper;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface DataRepository extends Repository<AbstractEntity, Long> {

    @Query(value = "select dp.id as _id, dp.payload as _payload from data_packet dp", rowMapperClass = DataDtoRowMapper.class)
    List<DataDto> findAll();

    @Query(value = "select dp.id as _id, dp.payload as _payload from data_packet dp where dp.id = :id", rowMapperClass = DataDtoRowMapper.class)
    Optional<DataDto> findById(Long id);

    @Modifying
    @Query(value = "insert into data_packet (id, payload) values (:id, :payload)")
    void save(Long id, String payload);

    @Modifying
    @Query(value = "update data_packet set payload = :payload where id = :id")
    void update(Long id, String payload);

    @Modifying
    @Query(value = "delete from data_packet where id = :id")
    void deleteById(Long id);

    @Query(value = "select exists(select * from data_packet dp where dp.id = :id)")
    boolean existsById(Long id);
}
