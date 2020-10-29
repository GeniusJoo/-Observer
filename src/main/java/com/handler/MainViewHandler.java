package com.handler;

import com.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: XianDaLi
 * Date: 2020/10/25 23:54
 * Remark:
 */
/*public class MainViewHandler implements ActionListener {
	private MainView mainView;
	public MainViewHandler(MainView mainView) {
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		String text = jButton.getText();
		if ("增加".equals(text)) {
			new AddStudentView(this.mainView);
		}else if ("修改".equals(text)) {
			Long[] selectedStudentIds = this.mainView.getSelectedStudentIds();
			if (selectedStudentIds.length != 1) {
				JOptionPane.showMessageDialog(mainView,"一次只能修改一条");
				return;
			}
			new UpdateStudentView(selectedStudentIds[0],mainView);
		}else if ("删除".equals(text)) {
			Long[] selectedStudentIds = this.mainView.getSelectedStudentIds();
			if (selectedStudentIds.length == 0) {
				JOptionPane.showMessageDialog(mainView,"请选择要删除的行");
				return;
			}
			int option = JOptionPane.showConfirmDialog(mainView,
					"确认要删除选中的" + selectedStudentIds.length + "条吗?","确认删除"
					,JOptionPane.YES_NO_OPTION);
			if (option != 0) { // 0:确认
				return;
			}
			boolean deleteResult = new StudentServiceImpl().delete(selectedStudentIds);
			if (deleteResult) {
				mainView.reloadTable();
			} else {
				JOptionPane.showMessageDialog(mainView,"删除失败");
			}
		}else if ("搜索".equals(text)) {
			mainView.setPageNow(1);
			mainView.reloadTable();
		}else if ("上一页".equals(text)) {
			mainView.setPageNow(mainView.getPageNow() - 1);
			mainView.reloadTable();
		}else if ("下一页".equals(text)) {
			mainView.setPageNow(mainView.getPageNow() + 1);
			mainView.reloadTable();
		}
	}
}*/
