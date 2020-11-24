package com.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Safe extends JFrame {
	public Safe()
	 {
		 setTitle("메뉴판");
		 SafePanel j = new SafePanel();
		 add(j);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//종료 셋팅
		 setSize(1000,550);	//절대 크기 조절 이미지 파일 때문에 필수
		 setVisible(true);	//항상 보여질 것 
	 }
	public class SafePanel extends JPanel
	{
		SafePanel(){
			super(new BorderLayout());
			ImageIcon img1 = new ImageIcon("koreaimages/안전수칙.png");
			JLabel lbl1 = new JLabel(img1);
			JButton pb1 = new JButton("부가메뉴로");
			pb1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			this.add(lbl1, "North");
			this.add(pb1, "South");
		}
	}
	public static void main(String[] args) 
	{
		new Safe();
	}
}