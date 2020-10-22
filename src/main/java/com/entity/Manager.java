package com.entity;

/**
 * Author: XianDaLi
 * Date: 2020/10/17 18:19
 * Remark:
 */
public class Manager {
	private int id;
	private String name;
	private String password;

	public Manager() {
	}

	public Manager(String name) {
		this.name = name;
		this.password = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}