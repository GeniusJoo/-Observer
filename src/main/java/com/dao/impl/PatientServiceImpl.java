package com.dao.impl;

import com.dao.PatientService;
import com.entity.Patient;
import com.utils.DBUtil;

import java.sql.*;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/10/25 1:05
 * Remark:
 */
public class PatientServiceImpl implements PatientService {
	@Override
	public boolean add(Patient patient) {
		String sql = "insert into patient(" +
				"date,patient_number,country,patient_information,local," +
				"travel,contact,actions,state,route,registration_date," +
				"modification_date,exposure) " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if(conn == null){
				return false;
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1,patient.getDate());
			ps.setInt(2,patient.getPatientNumber());
			ps.setString(3,patient.getCountry());
			ps.setString(4,patient.getPatientInformation());
			ps.setString(5,patient.getLocal());
			ps.setString(6,patient.getTravel());
			ps.setString(7,patient.getContact());
			ps.setString(8,patient.getActions());
			ps.setString(9,patient.getState());
			ps.setString(10,patient.getRoute());
			ps.setTimestamp(11,new Timestamp(patient.getRegistrationDate().getTime()));
			ps.setTimestamp(12,new Timestamp(patient.getModificationDate().getTime()));
			ps.setString(13,patient.getExposure());
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		String sql = "delete from patient where id = ?";
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
	public boolean update(Patient patient) {
//		String sql = "update patient set country=? "
		return false;
	}

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Patient selectById() {
		return null;
	}

	@Override
	public List selectByDate() {
		return null;
	}

	@Override
	public List selectByLocal() {
		return null;
	}
}
