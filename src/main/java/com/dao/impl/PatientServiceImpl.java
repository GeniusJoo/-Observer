package com.dao.impl;

import com.dao.PatientService;
import com.entity.Patient;
import com.utils.DBUtil;
import sun.security.pkcs11.Secmod;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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
				" route=? where id = ?";
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
			ps.setInt(5,patient.getId());
			return ps.executeUpdate() == 1;
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
				Timestamp registrationDate = rs.getTimestamp("registration_date");
				Timestamp modificationDate = rs.getTimestamp("modification_date");
				String exposure = rs.getString("exposure");
				listAll.add(new Patient(id,date,patientNumber,country,local,travel,travel,
						contact,actions,state,route,new Date(registrationDate.getTime()),new Date(modificationDate.getTime()),exposure));
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
				Timestamp registrationDate = rs.getTimestamp("registration_date");
				Timestamp modificationDate = rs.getTimestamp("modification_date");
				String exposure = rs.getString("exposure");
				patient = new Patient(id,date,patientNumber,country,local,travel,travel,
						contact,actions,state,route,new Date(registrationDate.getTime()),new Date(modificationDate.getTime()),exposure);
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
		String sql = "select * from patient where date = ?";
		List<Patient> listDate = new ArrayList<>();
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,date);
			rs = ps.executeQuery();
			while (rs.next()){
				Integer id = rs.getInt("id");
				Integer patientNumber = rs.getInt("patient_number");
				String country = rs.getString("country");
				String local = rs.getString("local");
				String travel = rs.getString("travel");
				String contact = rs.getString("contact");
				String actions = rs.getString("actions");
				String state = rs.getString("state");
				String route = rs.getString("route");
				Timestamp registrationDate = rs.getTimestamp("registration_date");
				Timestamp modificationDate = rs.getTimestamp("modification_date");
				String exposure = rs.getString("exposure");
				listDate.add(new Patient(id,date,patientNumber,country,local,travel,travel,
						contact,actions,state,route,new Date(registrationDate.getTime()),new Date(modificationDate.getTime()),exposure));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return listDate;
	}

	@Override
	public List selectByLocal(String local) {
		String sql = "select * from patient where local = ?";
		List<Patient> listLocal = new ArrayList<>();
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,local);
			rs = ps.executeQuery();
			while (rs.next()){
				Integer id = rs.getInt("id");
				String  date = rs.getString("date");
				Integer patientNumber = rs.getInt("patient_number");
				String country = rs.getString("country");
				String travel = rs.getString("travel");
				String contact = rs.getString("contact");
				String actions = rs.getString("actions");
				String state = rs.getString("state");
				String route = rs.getString("route");
				Timestamp registrationDate = rs.getTimestamp("registration_date");
				Timestamp modificationDate = rs.getTimestamp("modification_date");
				String exposure = rs.getString("exposure");
				listLocal.add(new Patient(id,date,patientNumber,country,local,travel,travel,
						contact,actions,state,route,new Date(registrationDate.getTime()),new Date(modificationDate.getTime()),exposure));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return listLocal;
	}

	@Override
	public int countPatient() {
		String sql = "select count(id) as countPs from patient";
		int res = 0;
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()){
				res = rs.getInt("countPs");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return res;
	}

	@Override
	public int countRecover() {
		String sql = "select count(id) as countRs from patient where state = '퇴원'";
		int res = 0;
		Connection conn = DBUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()){
				res = rs.getInt("countRs");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps,rs);
		}
		return res;
	}
}
