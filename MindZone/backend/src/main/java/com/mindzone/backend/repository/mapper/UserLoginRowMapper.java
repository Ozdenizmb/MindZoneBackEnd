package com.mindzone.backend.repository.mapper;

import com.mindzone.backend.dto.UserLoginDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginRowMapper implements RowMapper<UserLoginDto> {
    @Override
    public UserLoginDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserLoginDto(
                rs.getString("email"),
                rs.getString("password")
        );
    }
}
