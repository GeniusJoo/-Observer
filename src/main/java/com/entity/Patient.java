package com.entity;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/10/17 17:11
 * Remark:
 */
public class Patient {
	private int id; // 연변
	private Date date; // 확진일
	private int patientNumber; // 환자 번호
	private String country; // 국적
	private String patientInformation; // 환자정보
	private String local; // 지역
	private String travel; // 여행력
	private String contact; // 접촉력
	private String actions;// 조치사항
	private String state; // 상태
	private String route; // 이동경로
	private Date registrationDate; // 등록일
	private Date modificationDate; // 수정일
	private String exposure; // 노출여부

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(int patientNumber) {
		this.patientNumber = patientNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPatientInformation() {
		return patientInformation;
	}

	public void setPatientInformation(String patientInformation) {
		this.patientInformation = patientInformation;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTravel() {
		return travel;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getExposure() {
		return exposure;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}
}
