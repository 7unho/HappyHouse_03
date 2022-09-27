package com.april2nd.happyhouse_3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.april2nd.happyhouse_3.dto.HomeDto;
import com.april2nd.happyhouse_3.model.service.HomeService;
import com.april2nd.happyhouse_3.model.service.HomeServiceImpl;
import com.april2nd.happyhouse_3.util.ParameterCheck;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HomeService homeService;
	private Map<String, String> map;

	public void init() {
		homeService = HomeServiceImpl.getHomeService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		System.out.println("action>>"+act);

		String sido = ParameterCheck.nullToBlank(request.getParameter("sido"));
		String gugun = ParameterCheck.nullToBlank(request.getParameter("gugun"));
		String dong = ParameterCheck.nullToBlank(request.getParameter("dong"));
		String aptName = ParameterCheck.nullToBlank(request.getParameter("aptname"));

		String queryString = "?dong=" + dong + "&aptName=" + aptName;

		map = new HashMap<>();
		map.put("dong", dong);
		map.put("aptName", aptName);


		String path = "/apart/apart.jsp";
		if("list".equals(act)) {
			path = list(request, response);
			forward(request, response, path + queryString);
			System.out.println(path + queryString);
		}
		else if("detail".equals(act)) { //아파트 정보 상세 보기
			doDetail(request, response);
		}
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<HomeDto> list = homeService.listDeal(map);
			request.setAttribute("deals", list);
			return "/apart/apart.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글목록 조회 중 에러 발생 !");
			return "/error/error.jsp";
		}
	}

	private void doDetail(HttpServletRequest request, HttpServletResponse response) { //아파트 1개의 정보 확인
		String apt_code = request.getParameter("aptCode");
		System.out.println("aptCode >> "+ apt_code); //아파트 코드 불러오기

		//나머지 파라미터 받아옴
		String aptName = request.getParameter("aptName");
		String floor = request.getParameter("floor");
		String area = request.getParameter("area");
		String dong = request.getParameter("dong");
		String deal = request.getParameter("deal");

		try {
			HomeDto home = homeService.findApt(apt_code); //아파트 코드에 맞는 경도,위도 정보 가져옴
			System.out.println("경도 위도 출력>>"+home.getLng()+" , "+home.getLat());

			//나머지 act로 넘어온 파라미터값으로 아파트 이름, 층, area, 동, 거래금액 설정
			home.setApt_code(apt_code);
			home.setApt_name(aptName);
			home.setFloor(Integer.parseInt(floor));
			home.setArea(area);
			home.setDong_name(dong);
			home.setDeal_amount(deal);

			System.out.println("아파트 정보 : "+home.toString());

			request.setAttribute("detailAtp", home); //아파트 저장
			request.getRequestDispatcher("/apart/detail.jsp").forward(request, response); //상세페이지로 이동

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "아파트 조회 중 에러 발생");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}


}

