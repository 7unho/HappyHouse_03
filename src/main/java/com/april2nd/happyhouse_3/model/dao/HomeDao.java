package com.april2nd.happyhouse_3.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.april2nd.happyhouse_3.dto.HomeDto;

public interface HomeDao {
	List<HomeDto> listDeal(Map<String, String> map) throws SQLException;
	HomeDto findByAptCode(String apt_code) throws SQLException;
}
