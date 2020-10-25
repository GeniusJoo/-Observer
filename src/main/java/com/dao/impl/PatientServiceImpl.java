package com.dao.impl;

import com.dao.PatientService;
import com.entity.Patient;
import com.utils.DBUtil;
import sun.security.pkcs11.Secmod;

import java.sql.*;
import java.util.ArrayList;
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
		String sql = "update patient set contact=?, actions=?, state=?," +
				" route=?,modification_date=? where id = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if(conn == null){
				return false;
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1,patient.getContact());
			ps.setString(2,patient.getActions());
			ps.setString(3,patient.getState());
			ps.setString(4,patient.getRoute());
			ps.setTimestamp(5,new Timestamp(patient.getModificationDate().getTime()));
			ps.setInt(6,patient.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return false;
	}

	@Override
	public List selectAll() {
		String sql = "select * from patient";
		List<Patient> listAll = new ArrayList<>();
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			if(conn == null){
				return null;
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()){
				Integer id = rs.getInt("id");
				String  date = rs.getString("date");
				Integer patientNumber = rs.getInt("patient_number");
				String country = rs.getString("country");
				String local = rs.getString("local");
				String travel = rs.getString("travel");
				String contact = rs.getString("contact");
				String actions = rs.getString("actions");
				String state = rs.getString("state");
				String route = rs.getString("route");
				Date registrationDate = rs.getDate("registration_date");
				Date modificationDate = rs.getDate("modification_date");
				String exposure = rs.getString("exposure");
				listAll.add(new Patient(id,date,patientNumber,country,local,travel,travel,
						contact,actions,state,route,registrationDate,modificationDate,exposure));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return listAll;
	}

	@Override
	public Patient selectById(int id) {
		String sql = "select * from patient where id = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Patient patient = null;
		try {
			if(conn == null){
				return patient;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while (rs.next()){
				String  date = rs.getString("date");
				Integer patientNumber = rs.getInt("patient_number");
				String country = rs.getString("country");
				String local = rs.getString("local");
				String travel = rs.getString("travel");
				String contact = rs.getString("contact");
				String actions = rs.getString("actions");
				String state = rs.getString("state");
				String route = rs.getString("route");
				Date registrationDate = rs.getDate("registration_date");
				Date modificationDate = rs.getDate("modification_date");
				String exposure = rs.getString("exposure");
				patient = new Patient(id, date, patientNumber, country, local, travel, travel,
						contact, actions, state, route, registrationDate, modificationDate, exposure);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return patient;
	}

	@Override
	public List selectByDate(String date) {
		return null;
	}

	@Override
	public List selectByLocal(String local) {
		return null;
	}
}
