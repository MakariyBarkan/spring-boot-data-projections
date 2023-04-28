package com.example.demo.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.demo.domain.DataDto;
import org.springframework.jdbc.core.RowMapper;

public class DataDtoRowMapper implements RowMapper<DataDto> {

    @Override
    public DataDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DataDto()
                .setId(rs.getLong("_id"))
                .setPayload(rs.getString("_payload"));
    }
}
