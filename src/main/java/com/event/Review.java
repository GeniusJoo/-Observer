package com.event;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
public class Review extends JFrame  
{
	public Review()
	 {
		 setTitle("메뉴판");
		 ReviewPanel j = new ReviewPanel();
		 add(j);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//종료 셋팅
		 setSize(1000,550);	//절대 크기 조절 이미지 파일 때문에 필수
		 setVisible(true);	//항상 보여질 것 
	 }
	public class ReviewPanel extends JPanel	
	{
		ReviewPanel(){
			super(new BorderLayout());
			JPanel bl = new JPanel(new BorderLayout());
			JPanel test2 = new JPanel(new GridLayout(2,1));
			
			Font f1 = new Font("샘물체", Font.BOLD, 20);
			JTextArea area1= new JTextArea("->요즘도 마스크를 안 쓰는 사람들이 꽤 있네요\n",900,400);
			area1.append("->중ㆍ장기 후유증을 겪는 사람들 많아요 한번걸리면 끝은 아닙니다;;\n");
			area1.append("->확산율 너무 심해서 못피해갈거 같은데 일단 걸리면 개아픔\n");
			area1.append("->ㅇㄱㄹㅇ ㅋㅋ\n");
			area1.setFont(f1);
			area1.setEditable(false);
			area1.setForeground(Color.BLUE);
			
			JLabel jl = new JLabel("리뷰 입력후<Enter>키를 입력하세요");
			
			ActionListener l = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField tf = (JTextField)e.getSource();
					area1.append("->"+tf.getText()+"\n");
					tf.setText("");
				}
			};
			JTextField tf = new JTextField(30);
			tf.addActionListener(l);
			
			JButton pb1 = new JButton("부가메뉴로");
			pb1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			test2.add(jl);
			test2.add(tf);
			
			bl.add(area1, "Center");
			bl.add(test2, "South");
			bl.add(new JScrollPane(area1));
			
			
			this.add(bl, "Center");
			this.add(pb1, "South");
		}
	}
	public static void main(String[] args) 
	{
		new Review();
	}
}
