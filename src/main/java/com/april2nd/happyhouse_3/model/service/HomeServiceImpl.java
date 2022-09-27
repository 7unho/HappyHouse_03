package com.april2nd.happyhouse_3.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.april2nd.happyhouse_3.dto.HomeDto;
import com.april2nd.happyhouse_3.model.dao.HomeDao;
import com.april2nd.happyhouse_3.model.dao.HomeDaoImpl;

public class HomeServiceImpl implements HomeService{
	
	private static HomeService homeService = new HomeServiceImpl();
	
	private HomeDao homeDao;
	
	private HomeServiceImpl() {
		homeDao = HomeDaoImpl.getHomeDao();
	}
	
	public static HomeService getHomeService() {
		return homeService;
	}

	@Override
	public List<HomeDto> listDeal(Map<String, String> map) throws Exception {
		return homeDao.listDeal(map);
	}
	@Override
	public HomeDto findApt(String apt_code) throws SQLException {
		return homeDao.findByAptCode(apt_code);
	}


}
