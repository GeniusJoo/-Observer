package com.roadjava.student;

import javax.swing.*;

/**
 * Author: XianDaLi
 * Date: 2020/10/14 11:46
 * Remark:
 */
public class JframeTest {
	public static void main(String[] args) {
		// 容器组件:jframe,jpanel,jscrollpane    非容器组件:jbutton,jlabel,jtextfield
		JFrame jFrame = new JFrame("这是frame的标题");
		jFrame.setSize(600,400); // 单位:px
		jFrame.setVisible(true);
	}
}
