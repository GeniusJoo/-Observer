package com.roadjava.student;

import com.dao.PatientService;
import com.dao.impl.PatientServiceImpl;
import com.entity.Patient;
import com.utils.DBUtil;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/10/30 23:30
 * Remark:
 */

public class Test {

	public static void main(String[] args) {
		PatientService patient = new PatientServiceImpl();
		int res1 = patient.countPatient();
		int res2 = patient.countRecover();
		List<Patient> ps = patient.selectByDate("6.08.");
		System.out.println(ps);
		System.out.println(res1);
		System.out.println(res2);
	}



}
