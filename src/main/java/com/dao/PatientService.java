package com.dao;

import com.entity.Patient;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/10/25 0:53
 * Remark:
 */
public interface PatientService {
	boolean add(Patient patient);
	boolean deleteById(int id);
	boolean update(Patient patient);

	List selectAll(); // select all
	Patient selectById(); // select by id
	List selectByDate(); // select by date
	List selectByLocal(); // select by local



}
