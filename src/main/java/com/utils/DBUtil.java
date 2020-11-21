package com.utils;

import java.sql.*;

/**
 * Author: XianDaLi
 * Date: 2020/10/17 18:37
 * Remark:
 */
public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/Observer?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER_NAME = "root";
	private static final String PWD = "wldnjs203";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		try (Connection con = DriverManager.getConnection(URL,USER_NAME,PWD)) {
			System.out.println("DB 연동 성공");
			System.out.println(con);
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
