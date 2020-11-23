package com.handler;

import com.dao.ManagerService;
import com.dao.impl.ManagerServiceImpl;
import com.entity.Manager;
import com.main.menu;
import com.view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Author: XianDaLi
 * Date: 2020/10/25 23:49
 * Remark:
 */
public class LoginViewHandler extends KeyAdapter implements ActionListener {
	private LoginView loginView;
	public LoginViewHandler(LoginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(111);
		JButton jButton = (JButton) e.getSource();
		String text = jButton.getText();
		if ("Login".equals(text)) {
			login();
		}else if ("Reset".equals(text)) {
			loginView.getUserNameJTextField().setText("");
			loginView.getPwdJPasswordField().setText("");
		}
	}

	private void login() {

		String userName = loginView.getUserNameJTextField().getText();
		char[] password = loginView.getPwdJPasswordField().getPassword();
		String pwd = new String(password);
		System.out.println(userName + "   " + pwd);
		ManagerService managerService = new ManagerServiceImpl();
		Manager manager = new Manager();
		manager.setName(userName);
		manager.setPassword(pwd);
		boolean flag = managerService.login(manager);
		if (flag) {
//			new menu();
			menu me = new menu();
			me.setVisible(true);
			loginView.getjFrame().dispose();
			
		} else {
			JOptionPane.showMessageDialog(loginView.getjFrame(), "password is wrong!");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			login();
		}
	}
}