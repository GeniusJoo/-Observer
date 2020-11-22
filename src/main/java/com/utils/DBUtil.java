package com.utils;

import java.sql.*;

import javax.swing.table.DefaultTableModel;

/**
 * Author: XianDaLi
 * Date: 2020/10/17 18:37
 * Remark:
 */
public class DBUtil {
//	private static final String URL = "jdbc:mysql://localhost:3306/teamwork?useUnicode=true&characterEncoding=utf8&useSSL=false";
//	private static final String DRIVER = "com.mysql.jdbc.Driver";
//	private static final String USER_NAME = "root";
//	private static final String PWD = "123";
	
	// 익강님과 커넥터 버젼이 맞지 않고, db도 개인이 돌리기 때문에 저는 아래거로 사용하겠습니다.

	public static final String URL = "jdbc:mysql://127.0.0.1:3306/Observer?serverTimezone=UTC";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER_NAME = "root";
	public static final String PWD = "wldnjs203";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		try {
			System.out.println("DB 연동 성공");
			return DriverManager.getConnection(URL,USER_NAME,PWD);
		} catch (Exception e) {
			System.out.println("DB 연동 실패");
			e.printStackTrace();
		}
		return null;
	}

	/*
	关闭资源
	@param conn 连接对象
	@param ps   数据库操作对象
	@param rs   结果集
 */
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (rs != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closePs(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeConn(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
