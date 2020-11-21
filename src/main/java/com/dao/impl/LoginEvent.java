package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.utils.DBUtil;

public class LoginEvent {
	
	private LoginEvent() {}
	private static LoginEvent instance = new LoginEvent();
	public static LoginEvent getInstance() {
		return instance;
	}
	
	private Connection conn;// DB 연결 객체
	private PreparedStatement pstmt; // 쿼리 작성 객체
	private ResultSet rs; // 쿼리 결과 커서
	
	public int findUserIDandPassword(String name, String password) {
		conn = DBUtil.getConn();
		
		try {
			pstmt = conn.prepareStatement("select * from user where name = ? and password = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) return 1; // 로그인 성공
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1; //로그인 실패
	}

}
