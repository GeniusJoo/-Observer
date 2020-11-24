package com.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Self extends JFrame 
{
	 public Self()
	 {
		 setTitle("메뉴판");
		 SelfPanel j = new SelfPanel();
		 add(j);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//종료 셋팅
		 setSize(1000,550);	//절대 크기 조절 이미지 파일 때문에 필수
		 setVisible(true);	//항상 보여질 것 
	 }
	 class SelfPanel extends JPanel	
		{
			SelfPanel(){
				super(new BorderLayout());
				JPanel test = new JPanel(new GridLayout(3,1));
				JPanel side1 = new JPanel(new GridLayout(2,1));
				JPanel step1 = new JPanel(new GridLayout(1,2));
				JPanel side2 = new JPanel(new GridLayout(2,1));
				JPanel step2 = new JPanel(new GridLayout(1,2));
				JPanel side3 = new JPanel(new GridLayout(2,1));
				JPanel step3 = new JPanel(new GridLayout(1,2));
				testPanel1 tp1 = new testPanel1();
				testPanel2 tp2 = new testPanel2();
				testPanel3 tp3 = new testPanel3();
				
				JButton b1= new JButton("예");
				b1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"귀하는 코로나 확진자 일 수 있습니다. "
								+ " 근처 보건소를 방문하여 검사를 받아보세요");
					}
				});
				
				JButton b2= new JButton("아니오");
				b2.addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"귀하는 현재 건강한 상태입니다.");	
					}
				});
				JButton b3= new JButton("예");
				b3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {	
						JOptionPane.showMessageDialog(null,"귀하는 코로나 확진자 일 수 있습니다. "
								+ " 근처 보건소를 방문하여 검사를 받아보세요");
					}
				});
				
				JButton b4= new JButton("아니오");
				b4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"귀하는 현재 건강한 상태입니다.");
					}
				});
				
				JButton b5= new JButton("예");
				b5.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"결과가 나올 때 까지 집에서 자가격리 하십시오.");
					}
				});
				
				JButton b6= new JButton("아니오");
				b6.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"귀하는 현재 건강한 상태입니다."
								+ "안전수칙을 참고하여 준수하십시오.");
					}
				});
				
				JButton pb1 = new JButton("부가메뉴로");
				pb1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				step1.add(b1);
				step1.add(b2);
				side1.add(tp1);
				side1.add(step1);
				
				step2.add(b3);
				step2.add(b4);
				side2.add(tp2);
				side2.add(step2);
				
				step3.add(b5);
				step3.add(b6);
				side3.add(tp3);
				side3.add(step3);
				
				test.add(side1);
				test.add(side2);
				test.add(side3);
				
				this.add(test, "Center");
				this.add(pb1, "South");
			}
		}
	 class testPanel1 extends JPanel
		{
			protected void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				//폰트 설정 
				Font f1 = new Font("맑은고딕", Font.PLAIN, 20);
				
				//설정한 폰트 그리기 글자체,폰트,크기를 변경하여 총 12개의 다른 폰트 그리기
				g.setFont(f1);
				g.drawString("현재 아래에 해당하는 증상이 있습니까?", 10, 25);
				g.drawString("(발열, 오한, 두통, 근육통, 인후통, 콧물, 코막힘, 기침, 호흡곤란, 구토)", 10, 45);
				
			}
		}
		class testPanel2 extends JPanel
		{
			protected void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				//폰트 설정 
				Font f1 = new Font("맑은고딕", Font.PLAIN, 20);
				
				//설정한 폰트 그리기 글자체,폰트,크기를 변경하여 총 12개의 다른 폰트 그리기
				g.setFont(f1);
				g.drawString("최근 14일 이내에 방문(여행 포함)한 국가가 있습니까?", 10, 25);
			}
			
		}
		class testPanel3 extends JPanel
		{
			protected void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				//폰트 설정 
				Font f1 = new Font("맑은고딕", Font.PLAIN, 20);
				
				//설정한 폰트 그리기 글자체,폰트,크기를 변경하여 총 12개의 다른 폰트 그리기
				g.setFont(f1);
				g.drawString("선별진료소 등에서 코로나19 진단검사를 받은 후 검사가 진행중이며,", 10, 25);
				g.drawString("검사결과 통보를 기다리고 계신 상태입니까?,", 10, 45);
			}
		}
	public static void main(String[] args) 
	{
		new Self();
	}
}
