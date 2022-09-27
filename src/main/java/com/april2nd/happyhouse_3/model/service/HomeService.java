package com.april2nd.happyhouse_3.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.april2nd.happyhouse_3.dto.HomeDto;

public interface HomeService {
	
	List<HomeDto> listDeal(Map<String, String> map) throws Exception;
	HomeDto findApt(String apt_code) throws SQLException;
}
