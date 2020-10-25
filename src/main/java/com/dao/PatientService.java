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
	Patient selectById(int id); // select by id
	List selectByDate(String date); // select by date
	List selectByLocal(String local); // select by local

}
