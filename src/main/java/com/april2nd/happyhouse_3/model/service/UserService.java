package com.april2nd.happyhouse_3.model.service;

import com.april2nd.happyhouse_3.dto.UserDto;

import java.sql.SQLException;

public interface UserService {
    public UserDto login(String id, String pw) throws SQLException;
    public int	regist(UserDto user)			throws SQLException;

}
