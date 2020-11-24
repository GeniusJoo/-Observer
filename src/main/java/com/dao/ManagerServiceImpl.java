package com.dao;

import com.entity.Manager;
import com.utils.DBUtil;

import java.sql.*;


public class ManagerServiceImpl implements ManagerService {	//ManagerService를 implements 함. 로그인 할 때 필요함
	@Override
	public boolean login(Manager manager) {
//		String sql = "select password from manager where name = ?";
		String sql = "select password from user where name = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,manager.getName());
			rs = ps.executeQuery();
			boolean validateOk = false;
			while (rs.next()){
				String password = rs.getString(1);
				if(manager.getPassword().equals(password)){
					validateOk = true;
				}
			}
			return validateOk;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return false;
	}
}