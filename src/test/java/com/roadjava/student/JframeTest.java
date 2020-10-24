package com.roadjava.student;

import javax.swing.*;
import java.awt.*;

/**
 * Author: XianDaLi
 * Date: 2020/10/14 11:46
 * Remark:
 */
public class JframeTest {
	public static void main(String[] args) {
		// 容器组件:jframe,jpanel,jscrollpane    非容器组件:jbutton,jlabel,jtextfield
		JFrame jFrame = new JFrame("这是frame的标题");
		jFrame.setSize(1000,800); // 单位:px
		// 居中
		// 1.
//		jFrame.setLocationRelativeTo(null);
		// 2.自己计算位置来居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int offsetX = (screenSize.width - 1000) / 2;
		int offsetY = (screenSize.height - 800) / 2;
		jFrame.setLocation(offsetX,offsetY);

		// 关闭退出程序
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 大小不可改变
		jFrame.setResizable(true);

		jFrame.setVisible(true);
	}
}
