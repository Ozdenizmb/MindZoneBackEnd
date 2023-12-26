package com.mindzone.backend.repository.mapper;

import com.mindzone.backend.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserRowMapper implements RowMapper<UserDto> {
    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDto(
                UUID.fromString(rs.getString("id")),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getInt("age"),
                rs.getString("gender"),
                rs.getString("education"),
                rs.getInt("financial_situation"),
                rs.getString("chronic_disease"),
                rs.getString("psychology")
        );
    }
}
