package com.mindzone.backend.repository.query;

public class UserSqlQueries {

    private UserSqlQueries(){}

    public static final String INSERT_QUERY = "INSERT INTO USERS (first_name, last_name, email, password, phone_number, age, gender, education, financial_situation, chronic_disease, psychology) VALUES(?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String SELECT_LOGIN_QUERY = "SELECT email, password FROM USERS WHERE email = ?";

    public static final String SELECT_USER_QUERY = "SELECT id, first_name, last_name, email, phone_number, age, gender, education, financial_situation, chronic_disease, psychology FROM USERS WHERE email = ?";

}
