package com.april2nd.happyhouse_3.model.dao;

import com.april2nd.happyhouse_3.dto.UserDto;

import java.sql.SQLException;

public interface UserDao {
    public UserDto login(String id, String pw)	throws SQLException;
    public int 	regist(UserDto user) 			throws SQLException;

}
