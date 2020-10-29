package com.view;

import com.entity.Patient;
//import com.handler.AddPatientViewHandler;
import com.utils.DateUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Author: XianDaLi
 * Date: 2020/10/26 0:22
 * Remark:
 */
public class AddPatientView extends JDialog {
	/*
	JLabel dateLabel = new JLabel("확진일");
	JTextField dateText = new JTextField(20);
	JPanel datePanel = new JPanel();

	JLabel patientNumberLabel = new JLabel("환자 번호");
	JTextField patientNumberText = new JTextField(20);
	JPanel patientNumberPanel = new JPanel();

	JLabel countryLabel = new JLabel("국적");
	JTextField countryText = new JTextField(20);
	JPanel countryPanel = new JPanel();

	JLabel patientInformationLabel = new JLabel("환자 정보");
	JTextField patientInformationText = new JTextField(20);
	JPanel patientInformationPanel = new JPanel();

	JLabel localLabel = new JLabel("지역");
	JTextField localText = new JTextField(20);
	JPanel localPanel = new JPanel();

	JLabel travelLabel = new JLabel("여행력");
	JTextField travelText = new JTextField(20);
	JPanel travelPanel = new JPanel();

	JLabel contactLabel = new JLabel("접촉력");
	JTextField contactText = new JTextField(20);
	JPanel contactPanel = new JPanel();

	JLabel actionsLabel = new JLabel("조치사항");
	JTextField actionsText = new JTextField(20);
	JPanel actionsPanel = new JPanel();

	JLabel stateLabel = new JLabel("상태");
	JTextField stateText = new JTextField(20);
	JPanel statePanel = new JPanel();

	JLabel contactLabel = new JLabel("이동경로");
	JTextField contactText = new JTextField(20);
	JPanel contactPanel = new JPanel();

	JLabel contactLabel = new JLabel("접촉력");
	JTextField contactText = new JTextField(20);
	JPanel contactPanel = new JPanel();

	JLabel contactLabel = new JLabel("접촉력");
	JTextField contactText = new JTextField(20);
	JPanel contactPanel = new JPanel();

	JLabel contactLabel = new JLabel("접촉력");
	JTextField contactText = new JTextField(20);
	JPanel contactPanel = new JPanel();

	JButton addBtn = new JButton("确认");
	JPanel btnPanel = new JPanel();

	JPanel center = new JPanel(new GridLayout(9, 1));

	private AddPatientViewHandler addPatientViewHandler;

	public AddPatientView(MainView mainView) {
		super(mainView, "환자 추가", true);
		addPatientViewHandler = new AddPatientViewHandler(this, mainView);
		Container contentPane = getContentPane();


		datePanel.add(dateLabel);
		datePanel.add(dateText);
		center.add(datePanel);

		patientNumberPanel.add(patientNumberLabel);
		patientNumberPanel.add(patientNumberText);
		center.add(patientNumberPanel);

		countryPanel.add(countryLabel);
		countryPanel.add(countryText);
		center.add(countryPanel);

		patientInformationPanel.add(patientInformationLabel);
		patientInformationPanel.add(patientInformationText);
		center.add(patientInformationPanel);

		localPanel.add(localLabel);
		localPanel.add(localText);
		center.add(localPanel);

		travelPanel.add(travelLabel);
		travelPanel.add(travelText);
		center.add(travelPanel);

		contactPanel.add(contactLabel);
		contactPanel.add(contactText);
		center.add(contactPanel);

		actionsPanel.add(actionsLabel);
		actionsPanel.add(actionsText);
		center.add(actionsPanel);

		btnPanel.add(addBtn);
		addBtn.addActionListener(addPatientViewHandler);
		center.add(btnPanel);

		contentPane.add(center);

		setSize(800, 1000);
		setLocationRelativeTo(null);// 居中展示
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public Patient buildStudentDO() {
		// 构造患者对象
		Patient patient = new Patient();
		patient.setDate(dateText.getText());
		patient.setPatientNumber(patientNumberText.getText());
		patient.setBirthDay(DateUtil.convertStr2Date(countryText.getText()));
		patient.setHomeTown(patientInformationText.getText());
		patient.setCnScore(Double.valueOf(localText.getText()));
		patient.setEnScore(Double.valueOf(travelText.getText()));
		patient.setMathScore(Double.valueOf(actionsText.getText()));
		return patient;
	}*/
}