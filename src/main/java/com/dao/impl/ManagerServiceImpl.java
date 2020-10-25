package com.dao.impl;

import com.dao.ManagerService;
import com.entity.Manager;
import com.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/10/25 14:50
 * Remark:
 */
public class ManagerServiceImpl implements ManagerService {
	@Override
	public boolean addUser(Manager manager) {
		String sql = "insert into manager(name,password) values(?,?)";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if(conn == null){
				return false;
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1,manager.getName());
			ps.setString(2,manager.getPassword());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		String sql = "delete from manager where id = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if(conn == null){
				return false;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return false;
	}

	@Override
	public boolean updateUser(Manager manager) {
		String sql = "update manager set password = ? where id = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,manager.getPassword());
			ps.setInt(2,manager.getId());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return false;
	}

	@Override
	public boolean login(Manager manager) {
		String sql = "select password from manager where name = ?";
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

	/*@Override
	public List selectAllUser() {
		List<Manager> listUser = new ArrayList<>();
		String sql = "select * from manager";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()){
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				listUser.add(new Manager(id,name,password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}*/
}
