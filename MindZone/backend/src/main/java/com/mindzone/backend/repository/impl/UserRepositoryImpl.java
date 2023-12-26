package com.mindzone.backend.repository.impl;

import com.mindzone.backend.dto.UserCreateDto;
import com.mindzone.backend.dto.UserDto;
import com.mindzone.backend.dto.UserLoginDto;
import com.mindzone.backend.error.NotFoundException;
import com.mindzone.backend.repository.UserRepository;
import com.mindzone.backend.repository.mapper.UserLoginRowMapper;
import com.mindzone.backend.repository.mapper.UserRowMapper;
import com.mindzone.backend.repository.query.UserSqlQueries;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.PreparedStatement;
import java.util.UUID;

import static com.mindzone.backend.constant.JdbcConstants.JDBC_TEMPLATE;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate UserJdbcTemplate;

    public UserRepositoryImpl(@Qualifier(JDBC_TEMPLATE) JdbcTemplate jdbcTemplate){
        this.UserJdbcTemplate = jdbcTemplate;
    }

    @Override
    public UUID createUser(UserCreateDto userCreateDto) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            UserJdbcTemplate.update(connection -> {
                        PreparedStatement ps = connection.prepareStatement(UserSqlQueries.INSERT_QUERY, new String[] {"id"});
                        ps.setString(1, userCreateDto.firstName());
                        ps.setString(2, userCreateDto.lastName());
                        ps.setString(3, userCreateDto.eMail());
                        ps.setString(4, userCreateDto.password());
                        ps.setString(5, userCreateDto.phoneNumber());
                        ps.setInt(6, userCreateDto.age());
                        ps.setString(7,userCreateDto.gender());
                        ps.setString(8, userCreateDto.education());
                        ps.setInt(9, userCreateDto.financialSituation());
                        ps.setString(10, userCreateDto.chronicDisease());
                        ps.setString(11,userCreateDto.psychology());
                        return ps;
                    }, keyHolder
            );
            return (UUID) keyHolder.getKeys().get("id");
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public UserDto loginUser(UserLoginDto userLoginDto) {
        try{
            UserLoginDto databaseData = UserJdbcTemplate.queryForObject(
                    UserSqlQueries.SELECT_LOGIN_QUERY, new UserLoginRowMapper(), userLoginDto.email());

            if(databaseData.password() == null || !databaseData.password().equals(userLoginDto.password())) {
                throw new NotFoundException();
            }
            return UserJdbcTemplate.queryForObject(
                    UserSqlQueries.SELECT_USER_QUERY, new UserRowMapper(), userLoginDto.email());
        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
