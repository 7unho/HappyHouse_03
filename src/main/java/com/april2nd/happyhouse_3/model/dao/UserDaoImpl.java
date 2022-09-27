package com.april2nd.happyhouse_3.model.dao;

import com.april2nd.happyhouse_3.dto.UserDto;
import com.april2nd.happyhouse_3.util.DBUtil;

import java.sql.*;

public class UserDaoImpl implements UserDao{
    DBUtil dbUtil = DBUtil.getInstance();

    private static UserDaoImpl instance = new UserDaoImpl();
    private UserDaoImpl() {}
    public static UserDaoImpl getInstance() {return instance;}

    @Override
    public UserDto login (String id, String pw) throws SQLException {
        Connection 			conn 		= null;
        PreparedStatement 	pstmt 		= null;
        ResultSet 			rs 			= null;
        UserDto 				loginInfo 	= null;

        try {
            conn = dbUtil.getConnection();
            String sql = "SELECT id , pw FROM user WHERE id = ? AND pw=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,pw);

            rs = pstmt.executeQuery();

            if(rs.next()){
                loginInfo = new UserDto();
                loginInfo.setId(rs.getString("id"));
                loginInfo.setPw(rs.getString("pw"));
            }

            return loginInfo;
        }
        finally {
            dbUtil.close(pstmt,conn);
        }
    }

    @Override
    public int regist(UserDto user) throws SQLException {
        Connection 			conn 	= null;
        PreparedStatement 	pstmt 	= null;

        try {
            conn 	= dbUtil.getConnection();											// 1. DB 연결
            String sql = "INSERT INTO user (id,pw,email,name,age) valuses (?,?,?,?,?)";	// 2. DB 서버에 sql문 먼저 전달 (데이터 제외)
            // 회원 정보 입력
            pstmt.setString(1,user.getId());
            pstmt.setString(2,user.getPw());
            pstmt.setString(3,user.getEmail());
            pstmt.setString(4,user.getName());
            pstmt.setInt(5, user.getAge());

            pstmt 	= conn.prepareStatement(sql); 										// 4. 미리 전달된 sql문 실행 요청 (데이터와 함께)

            int resultCnt = pstmt.executeUpdate();
            return resultCnt;
        }
        finally {
            dbUtil.close(pstmt,conn);
        }
    }

}
