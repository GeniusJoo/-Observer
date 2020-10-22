package com.utils;

import java.sql.*;

/**
 * Author: XianDaLi
 * Date: 2020/10/17 18:37
 * Remark:
 */
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/teamwork?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USER_NAME = "root";
	private static final String PWD = "123";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		try {
			return DriverManager.getConnection(URL,USER_NAME,PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
