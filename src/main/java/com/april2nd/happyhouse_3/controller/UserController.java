package com.april2nd.happyhouse_3.controller;

import com.april2nd.happyhouse_3.dto.UserDto;
import com.april2nd.happyhouse_3.model.service.UserService;
import com.april2nd.happyhouse_3.model.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService service = UserServiceImpl.getInstance();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //<a href="url">   <form action="url">   location.href="url"
        process(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //<form action="url" method="post">
        request.setCharacterEncoding("UTF-8");
        process(request,response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //요청 분석  ==> 기능 분기 메서드 호출

        //2.
        String action = request.getParameter("action"); //클라이언트는 action키값을 통해 요청하자!!
        System.out.println("action>>>"+ action);
        try {
            if(action==null) {
                response.sendRedirect(request.getContextPath());	// main 페이지로 돌아가기
            }else if(action.equals("form")) {//로그인폼 요청
                //		  response.sendRedirect(request.getContextPath()+"/note/registNote.jsp");
                //5.
                request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            }else if(action.equals("login")) {//DB로그인 요청
                doLogin(request,response);
            }else if(action.equals("logout")) {//로그아웃 요청
                doLogout(request,response);
            }

        }catch(Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error/error.jsp").forward(request, response);
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //1.
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        //3.
        UserDto userInfo = service.login(id,pw); //로그인이 잘 되었다면
        //로그인이 안되었다면 userInfo의 값은 null

        if(userInfo != null) {//로그인 성공
            //로그인 성공시 세션을 사용하여 브라우저에서 계속 유지 ==> 세션 로그인!!
            HttpSession session = request.getSession();
            //4.
            session.setAttribute("userInfo", userInfo);

            //쿠키 설정!!
            String remember = request.getParameter("remember");
            System.out.println("remember>>>"+ remember);

            if(remember != null) {//아이디를 저장하고 싶다!!

//				Cookie cookie = new Cookie(String name,String value);
                Cookie cookie = new Cookie("savedId", id);
                cookie.setPath(request.getContextPath());
                cookie.setMaxAge(60*60*24*365);//유효기간 1년
                response.addCookie(cookie); //사용자PC에 저장

            }else {//아이디를 저장하고 싶지않다!!
                Cookie cookie = new Cookie("savedId", id);
                cookie.setPath(request.getContextPath());
                cookie.setMaxAge(0);//saveId쿠키를 사용하지 않겠음
                response.addCookie(cookie); //사용자PC에 저장
            }

        }else {//로그인 실패
            request.setAttribute("msg", "로그인 실패");
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }

        //5.
        response.sendRedirect(request.getContextPath());
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
        request.getSession().invalidate();
        //메인페이지로 이동
        response.sendRedirect(request.getContextPath());

    }

}

