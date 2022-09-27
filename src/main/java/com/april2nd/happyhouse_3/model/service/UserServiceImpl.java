package com.april2nd.happyhouse_3.model.service;

import com.april2nd.happyhouse_3.dto.UserDto;
import com.april2nd.happyhouse_3.model.dao.UserDaoImpl;

import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    private UserDaoImpl dao = UserDaoImpl.getInstance();

    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public UserDto login(String id, String pw) throws SQLException {
        return dao.login(id, pw);
    }

    @Override
    public int regist(UserDto user) throws SQLException {
        return dao.regist(user);
    }

}
