package com.view;

import com.dao.PatientService;
import com.dao.impl.PatientServiceImpl;
//import com.handler.MainViewHandler;
import com.utils.DimensionUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Author: XianDaLi
 * Date: 2020/10/25 23:52
 * Remark:
 */
public class MainView extends JFrame {
/*	MainViewStudentJtable mainViewStudentJtable = new MainViewStudentJtable();
	JButton addBtn = new JButton("增加");
	JButton updateBtn = new JButton("修改");
	JButton deleteBtn = new JButton("删除");
	JTextField jTextField = new JTextField(20);
	JButton searchBtn = new JButton("搜索");
	JPanel northJpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

	JButton preBtn = new JButton("上一页");
	JButton nextBtn = new JButton("下一页");
	JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	private int pageNow = 1;
	private int pageSize = 10;
	private int totalCount = 0;
	private MainViewHandler mainViewHandler;
	public MainView () {
		super("学生成绩管理系统");

		mainViewHandler = new MainViewHandler(this);
		addBtn.addActionListener(mainViewHandler);
		updateBtn.addActionListener(mainViewHandler);
		deleteBtn.addActionListener(mainViewHandler);
		searchBtn.addActionListener(mainViewHandler);
		northJpanel.add(addBtn);
		northJpanel.add(updateBtn);
		northJpanel.add(deleteBtn);
		northJpanel.add(jTextField);
		northJpanel.add(searchBtn);

		Container contentPane = this.getContentPane();
		contentPane.add(northJpanel,BorderLayout.NORTH);


		Rectangle bounds = DimensionUtil.getBounds();
		PatientService patientService = new PatientServiceImpl();
		this.pageSize = Math.floorDiv(bounds.height,30);
		StudentTableDataDTO dto = patientService.retrieveList(this.buildRequest());
		setPageValue(dto);
		mainViewStudentJtable.setModel(StudentTableModel.assembleTableModel(dto.getData()));
		mainViewStudentJtable.renderRule();
		toggle();

		JScrollPane jScrollPane = new JScrollPane(mainViewStudentJtable);
		// 不需要将jscrollpanel放入jpanel，再把jpanel放入contentPane的中部，会导致
		// 很小的一部分。JScroLLPane只能放一个组件，当有多个组件时将多个组件放在Jpanel中，
		// 再将panel放在JScroLLPane中
		// jScrollPane.getHeight()在setVisible(true);之后才有值
		contentPane.add(jScrollPane,BorderLayout.CENTER);

		preBtn.addActionListener(mainViewHandler);
		nextBtn.addActionListener(mainViewHandler);
		southPanel.add(preBtn);
		southPanel.add(nextBtn);
		contentPane.add(southPanel,BorderLayout.SOUTH);


		// 下左右还是有点空隙，需要设置上，避免点击缩小侯看不到了
		setBounds(bounds);
		// 最简单的全屏填充的方法
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);// 居中展示
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);

	}

	private void setPageValue(StudentTableDataDTO dto) {
		this.totalCount = dto.getTotalCount();
		this.pageNow = dto.getPageNow();
		this.pageSize = dto.getPageSize();
	}

	public void reloadTable() {
		StudentService studentService = new StudentServiceImpl();
		StudentRequest request = buildRequest();
		StudentTableDataDTO dto = studentService.retrieveList(request);
		setPageValue(dto);
		StudentTableModel.updateTableModel(dto.getData());
		mainViewStudentJtable.renderRule();
		toggle();
	}

	private StudentRequest buildRequest() {
		StudentRequest request = new StudentRequest();
		request.setPageNow(pageNow);
		request.setPageSize(pageSize);
		request.setSearchWord(jTextField.getText().trim());
		return request;
	}

	public Long[] getSelectedStudentIds() {
		int[] selectedRows = mainViewStudentJtable.getSelectedRows();
		Long[] selectedStudentIds = new Long[selectedRows.length];
		for (int i=0;i<selectedRows.length;i++) {
			int selectedRowIndex = selectedRows[i];
			Object studentIdObj = mainViewStudentJtable.getValueAt(selectedRowIndex, 0);
			selectedStudentIds[i] = Long.valueOf(studentIdObj.toString());
		}
		return selectedStudentIds;
	}

	private void toggle() {
		if (this.pageNow == 1) {
			preBtn.setVisible(false);
		}else {
			preBtn.setVisible(true);
		}
		int pageCount = 0;
		if (totalCount % pageSize != 0) {
			pageCount = totalCount/pageSize + 1;
		} else {
			pageCount = totalCount/pageSize;
		}
		if (pageNow == pageCount) {
			nextBtn.setVisible(false);
		} else {
			nextBtn.setVisible(true);
		}
	}
	public static void main(String[] args) {
		new MainView();
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}*/
}
