package com.dao;

import com.entity.Manager;

/**
 * Author: XianDaLi
 * Date: 2020/10/25 0:52
 * Remark:
 */
public interface ManagerService {
	boolean addUser(Manager manager);
	boolean deleteUser(int id);
	boolean updateUser(Manager manager);
	boolean login(Manager manager);
//	List selectAllUser(); // select all

}
