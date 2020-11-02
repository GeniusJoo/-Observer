package com.handler;

import com.dao.PatientService;
import com.dao.impl.PatientServiceImpl;
import com.entity.Patient;
import com.view.AddPatientView;
import com.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: XianDaLi
 * Date: 2020/10/26 0:20
 * Remark:
 */
/*
public class AddPatientViewHandler implements ActionListener {
	private AddPatientView addPatientView;
	private MainView mainView;
	public AddPatientViewHandler(AddPatientView addPatientView, MainView mainView) {
		this.addPatientView = addPatientView;
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		String text = jButton.getText();
		if ("确认".equals(text)) {
			PatientService patientService = new PatientServiceImpl();
			Patient patient = addPatientView.buildStudentDO();


			boolean result = patientService.add(Patient);
			if (result) {
				mainView.reloadTable();
				addStudentView.dispose();
			}else{
				JOptionPane.showMessageDialog(addStudentView,"添加出错");
			}
		}
	}
}*/
