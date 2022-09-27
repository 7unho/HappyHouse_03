package com.april2nd.happyhouse_3.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.april2nd.happyhouse_3.dto.HomeDto;
import com.april2nd.happyhouse_3.util.DBUtil;

public class HomeDaoImpl implements HomeDao{
	private static HomeDao homeDao = new HomeDaoImpl();
	
	private DBUtil dbUtil;
	
	private HomeDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static HomeDao getHomeDao() {
		return homeDao;
	}

	@Override
	public List<HomeDto> listDeal(Map<String, String> map) throws SQLException {
		List<HomeDto> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {
			conn = dbUtil.getConnection();
			
			String dong = map.get("dong");
			String aptName = map.get("aptName");
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT i.aptcode, apartmentname, floor, area, dong, dealamount \n");
			sql.append("FROM housedeal d, houseinfo i \n");
			sql.append("WHERE d.aptcode = i.aptcode \n");
			if(!dong.isEmpty()) {
				sql.append("AND i.dongCode = ? \n");

				if(!aptName.isEmpty()){
					sql.append("AND apartmentname like ? \n");
				}
			}
			pstmt = conn.prepareStatement(sql.toString());
			
			
			if(!dong.isEmpty()) {
				pstmt.setString(1, dong);

				if(!aptName.isEmpty()){
					pstmt.setString(2, "%" + aptName + "%");
				}
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HomeDto home = new HomeDto();
				
				home.setApt_code(rs.getString("i.aptcode"));
				home.setApt_name(rs.getString("apartmentname"));
				home.setFloor(rs.getInt("floor"));
				home.setArea(rs.getString("area"));
				home.setDong_name(rs.getString("dong"));
				home.setDeal_amount(rs.getString("dealamount"));
				
				list.add(home);
			}
		} finally {
			dbUtil.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public HomeDto findByAptCode(String apt_code) throws SQLException { //아파트 1개 검색
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HomeDto home = null;

		try {
			conn = dbUtil.getConnection();
			String sql = "select lng, lat from houseinfo where aptcode = ?"; //해당 아파트와 일치하는 곳의 경도와 위도만 불러온다
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, apt_code);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				home = new HomeDto();
				home.setLng(rs.getString("lng")); //경도 설정
				home.setLat(rs.getString("lat")); //위도 설정
			}
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}

		return home;
	}

}
