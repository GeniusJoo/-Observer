package com.roadjava.student;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Author: XianDaLi
 * Date: 2020/10/14 11:46
 * Remark:
 */
public class JframeTest extends JFrame{
//	JButton jButton;

	public JframeTest(){
		// 容器组件:jframe,jpanel,jscrollpane    非容器组件:jbutton,jlabel,jtextfield
		super("测试边界布局");

//		jButton = new JButton("这是一个按钮");
		Container contentPane = getContentPane();
//		contentPane.add(jButton);

		// 设置窗体图标
//		URL resource = JframeTest.class.getClassLoader().getResource("images/cat.jpg");
//		Image image = new ImageIcon(resource).getImage();
//		setIconImage(image);
//		setSize(1000,800); // 单位:px
		// 居中
		// 1.
//		jFrame.setLocationRelativeTo(null);
		// 2.自己计算位置来居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int offsetX = (screenSize.width - 1000) / 2;
		int offsetY = (screenSize.height - 800) / 2;
		setLocation(offsetX,offsetY);

		// 关闭退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 大小不可改变
		setResizable(true);

		setVisible(true);
	}

	public static void main(String[] args) {
		new JframeTest();
		System.out.println("dasd");
	}
}
