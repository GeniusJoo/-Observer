package com.view;

import com.handler.LoginViewHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

/**
 * Author: XianDaLi
 * Date: 2020/10/25 23:50
 * Remark:
 */
public class LoginView {
	// 定义登录界面的组件 로그인 인터페이스를 정의하는 모듈입니다.
	// 北部 상단
	private JLabel titleJLabel = new JLabel("Observer",SwingConstants.CENTER);

	// 中部 중단
	private JLabel userNameJLabel = new JLabel("ID:");
	private JTextField userNameJTextField = new JTextField();

	private JLabel pwdJLabel = new JLabel("Password:");
	private JPasswordField pwdJPasswordField = new JPasswordField();

	private JButton loginBtn = new JButton("Login");
	private JButton resetBtn = new JButton("Reset");

	SpringLayout formLayout = new SpringLayout();
	private JPanel formPanel = new JPanel(formLayout);

	private JFrame jFrame = new JFrame("Observer");

	// 托盘 트레이를 받쳐준다?
	private TrayIcon trayIcon;
	private SystemTray systemTray;

	private LoginViewHandler loginViewHandler;
	public LoginView( ) {
		loginViewHandler  = new LoginViewHandler(this);
		// 北部 상단
		Font font = new Font("楷体", Font.PLAIN, 40);
		titleJLabel.setFont(font);
		titleJLabel.setPreferredSize(new Dimension(0, 80));

		// 中部	중단
		Font centerFont = new Font("微软雅黑", Font.PLAIN, 20);
		userNameJLabel.setFont(centerFont);
		formPanel.add(userNameJLabel);
		userNameJTextField.setFont(centerFont);
		userNameJTextField.setPreferredSize(new Dimension(200, 30));
		formPanel.add(userNameJTextField);

		pwdJLabel.setFont(centerFont);
		formPanel.add(pwdJLabel);
//		pwdJPasswordField.setFont(centerFont); // 导致无法显示回显字符
		pwdJPasswordField.setPreferredSize(new Dimension(200,30));
		formPanel.add(pwdJPasswordField);

		loginBtn.setFont(centerFont);
		resetBtn.setFont(centerFont);
		formPanel.add(loginBtn);
		formPanel.add(resetBtn);
		// 设置各个组件的弹簧布局位置 각 모듈의 스프

		// 设置用户这一行
		Spring childrenWidth = Spring.sum(Spring.sum(Spring.width(userNameJLabel),
				Spring.width(userNameJTextField)), Spring.constant(10));
		int offset = childrenWidth.getValue() / 2;
		formLayout.putConstraint(SpringLayout.WEST, userNameJLabel, -offset,
				SpringLayout.HORIZONTAL_CENTER, formPanel);
		formLayout.putConstraint(SpringLayout.WEST, userNameJTextField, 10,
				SpringLayout.EAST, userNameJLabel);

		formLayout.putConstraint(SpringLayout.VERTICAL_CENTER, userNameJLabel, -80,
				SpringLayout.VERTICAL_CENTER, formPanel);
		formLayout.putConstraint(SpringLayout.NORTH, userNameJTextField, 0,
				SpringLayout.NORTH, userNameJLabel);

		// 设置密码这一行
		SpringLayout.Constraints uNameLabelC = formLayout.getConstraints(userNameJLabel);
		SpringLayout.Constraints pwdLabelC = formLayout.getConstraints(pwdJLabel);
		pwdLabelC.setConstraint(SpringLayout.NORTH,Spring.sum(
				uNameLabelC.getConstraint(SpringLayout.SOUTH),Spring.constant(30)
		));
		pwdLabelC.setConstraint(SpringLayout.EAST,uNameLabelC.getConstraint(SpringLayout.EAST));

		SpringLayout.Constraints pwdTextC = formLayout.getConstraints(pwdJPasswordField);
		pwdTextC.setConstraint(SpringLayout.WEST,Spring.sum(pwdLabelC.getConstraint(SpringLayout.EAST),
				Spring.constant(10)));
		pwdTextC.setConstraint(SpringLayout.NORTH,pwdLabelC.getConstraint(SpringLayout.NORTH));

		formLayout.putConstraint(SpringLayout.WEST,loginBtn,20,SpringLayout.WEST,pwdJLabel);
		formLayout.putConstraint(SpringLayout.NORTH,loginBtn,20,SpringLayout.SOUTH,pwdJLabel);

		formLayout.putConstraint(SpringLayout.WEST,resetBtn,50,SpringLayout.EAST,loginBtn);
		formLayout.putConstraint(SpringLayout.NORTH,resetBtn,0,SpringLayout.NORTH,loginBtn);

		// 设置jframe图标
		URL resource = this.getClass().getClassLoader().getResource("images/login.png");
		Image image = new ImageIcon(resource).getImage();
		jFrame.setIconImage(image);
		Container contentPane = jFrame.getContentPane();
		// 定义根容器布局
		contentPane.setLayout(new BorderLayout());

		contentPane.add(titleJLabel,BorderLayout.NORTH);
		contentPane.add(formPanel,BorderLayout.CENTER);

		// 托盘
		if (SystemTray.isSupported()) {
			systemTray = SystemTray.getSystemTray();
			trayIcon = new TrayIcon(image);
			// 设置托盘图标自适应大小，不然托盘显示不出图片
			trayIcon.setImageAutoSize(true);
			try {
				systemTray.add(trayIcon);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			jFrame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowIconified(WindowEvent e) {
					jFrame.dispose();
				}
			});

			trayIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 1) {
						jFrame.setExtendedState(JFrame.NORMAL);
					}
					jFrame.setVisible(true);
				}
			});
		}

		// 事件监听
		resetBtn.addActionListener(loginViewHandler);
		loginBtn.addActionListener(loginViewHandler);
		loginBtn.addKeyListener(loginViewHandler);

		// 按回车默认激活的按钮，不然需要获取焦点才可以
		jFrame.getRootPane().setDefaultButton(loginBtn);

		System.out.println("rootpane==contpanel:"+(jFrame.getRootPane()==jFrame.getContentPane()));
		jFrame.setSize(600,400);
		jFrame.setLocationRelativeTo(null);// 居中展示
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setResizable(true);
		jFrame.setVisible(true);
	}

	public JTextField getUserNameJTextField() {
		return userNameJTextField;
	}

//	public JTextField getPwdJPasswordField() {
//		return pwdJPasswordField;
//	}
	
	public JPasswordField getPwdJPasswordField() {
		return pwdJPasswordField;
	}

	public JFrame getjFrame() {
		return jFrame;
	}
}