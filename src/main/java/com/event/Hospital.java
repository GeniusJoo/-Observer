package com.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Hospital extends JFrame
{
	public Hospital()
	 {
		 setTitle("메뉴판");
		 HospitalPanel j = new HospitalPanel();
		 add(j);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//종료 셋팅
		 setSize(1000,550);	//절대 크기 조절 이미지 파일 때문에 필수
		 setVisible(true);	//항상 보여질 것 
	 }
	public class HospitalPanel extends JPanel{
		HospitalPanel()
		{
			super(new BorderLayout());
			JLabel text = new JLabel("거주중이신 지역을 선택해주세요");
			JPanel gp = new JPanel(new GridLayout(5,5));
		
			Font f1 = new Font("샘물체", Font.BOLD, 25);
			JTextArea area= new JTextArea(30,20);
			area.setFont(f1);
			area.setText("");
			area.setEditable(false);
			area.setForeground(Color.RED);
			JPanel center= new JPanel(new GridLayout(2,1));
		
			JButton pb1 = new JButton("부가메뉴로");
			pb1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		
			JButton l1 = new JButton("강남구");
			l1.addActionListener(e->area.setText("강남구 근처 병원은 삼성서울병원, 우리들병원, 강남구보건소 가 있습니다."));
			JButton l2 = new JButton("강동구");
			l2.addActionListener(e->area.setText("강동구 근처 병원은 강동성심병원, 강동경희대학교병원, 중앙보훈병원 이 있습니다."));
			JButton l3 = new JButton("강북구");
			l3.addActionListener(e->area.setText("강북구 근처 병원은 햇빛병원, 민병원, 강북구보건소 가 있습니다."));
			JButton l4 = new JButton("강서구");
			l4.addActionListener(e->area.setText("강서구 근처 병원은 서울부민병원, 차앤유의원, 강서구보건소 가 있습니다."));
			JButton l5 = new JButton("구로구");
			l5.addActionListener(e->area.setText("구로구 근처 병원은 구로성심병원, 우리아이들병원, 고려대학교구로병원 이 있습니다."));
			JButton l6 = new JButton("금천구");
			l6.addActionListener(e->area.setText("금천구 근처 병원은 희명병원, 홀인원의원, 새움병원 이 있습니다."));
			JButton l7 = new JButton("관악구");
			l7.addActionListener(e->area.setText("관악구 근처 병원은 에이치플러스 양지병원, 사랑의병원, 관악구보건소 가 있습니다."));
			JButton l8 = new JButton("광진구");
			l8.addActionListener(e->area.setText("광진구 근처 병원은 혜민병원, 건국대학교병원, 국립정신건강센터 가 있습니다."));
			JButton l9 = new JButton("노원구");
			l9.addActionListener(e->area.setText("노원구 근처 병원은 노원을지대학교병원, 새봄재활의학과의원, 노원구보건소 가 있습니다."));
			JButton l10 = new JButton("도봉구");
			l10.addActionListener(e->area.setText("도봉구 근처 병원은 한일병원, 에이치큐브병원, 바로선병원 이 있습니다."));
			JButton l11 = new JButton("동대문구");
			l11.addActionListener(e->area.setText("동대문구 근처 병원은 삼육서울병원, 하늘병원, 동대문구보건소 가 있습니다."));
			JButton l12 = new JButton("동작구");
			l12.addActionListener(e->area.setText("동작구 근처 병원은 보라매병원, 중앙대학교병원, 동작구보건소 가 있습니다."));
			JButton l13 = new JButton("마포구");
			l13.addActionListener(e->area.setText("마포구 근처 병원은 샤인스타의원, 신촌연세병원, 마포보건소 가 있습니다."));
			JButton l14 = new JButton("서대문구");
			l14.addActionListener(e->area.setText("서대문구 근처 병원은 신촌세브란스병원, 동신병원, 서대문구보건소 가 있습니다."));
			JButton l15 = new JButton("서초구");
			l15.addActionListener(e->area.setText("서초구 근처 병원은 가톨릭성모병원, 톡스앤필의원, 기쁨병원 이 있습니다."));
			JButton l16 = new JButton("성동구");
			l16.addActionListener(e->area.setText("성동구 근처 병원은 한양대학교병원, 성동구보건소, 다니엘클리닉 이 있습니다."));
			JButton l17 = new JButton("성북구");
			l17.addActionListener(e->area.setText("성북구 근처 병원은 고려대학교의료 안암병원, 성북구보건소, 서울척병원 이 있습니다."));
			JButton l18 = new JButton("송파구");
			l18.addActionListener(e->area.setText("송파구 근처 병원은 서울아산병원, 송파구보건소, 한솔병원 이 있습니다."));
			JButton l19 = new JButton("양천구");
			l19.addActionListener(e->area.setText("양천구 근처 병원은 이대목동병원, 홍익병원, 양천구보건소 가 있습니다."));
			JButton l20 = new JButton("영등포구");
			l20.addActionListener(e->area.setText("영등포구 근처 병원은 건양의료재단, 성애병원, 영등포보건소 가 있습니다."));
			JButton l21 = new JButton("용산구");
			l21.addActionListener(e->area.setText("용산구 근처 병원은 순천향대학교서울병원, 용산구보건소, 금강아산병원 이 있습니다."));
			JButton l22 = new JButton("은평구");
			l22.addActionListener(e->area.setText("은평구 근처 병원은 본서부병원, 은평구보건소, 유드림의원 이 있습니다."));
			JButton l23 = new JButton("종로구");
			l23.addActionListener(e->area.setText("종로구 근처 병원은 서울대학교병원, 강북삼성병원, 라미에르의원 이 있습니다."));
			JButton l24 = new JButton("중구");
			l24.addActionListener(e->area.setText("중구 근처 병원은 서울송도병원, 제일병원, 서울백병원 이 있습니다."));
			JButton l25 = new JButton("중랑구");
			l25.addActionListener(e->area.setText("중랑구 근처 병원은 중랑구보건소, 서울특별시서울의료원, 동부제일병원 이 있습니다."));
		
			gp.add(l1);
			gp.add(l2);
			gp.add(l3);
			gp.add(l4);
			gp.add(l5);
			gp.add(l6);
			gp.add(l7);
			gp.add(l8);
			gp.add(l9);
			gp.add(l10);
			gp.add(l11);
			gp.add(l12);
			gp.add(l13);
			gp.add(l14);
			gp.add(l15);
			gp.add(l16);
			gp.add(l17);
			gp.add(l18);
			gp.add(l19);
			gp.add(l20);
			gp.add(l21);
			gp.add(l22);
			gp.add(l23);
			gp.add(l24);
			gp.add(l25);
		
			center.add(gp);
			center.add(area);
		
			this.add(text,"North");
			this.add(center, "Center");
			this.add(pb1,"South");
		
		}
	}
	public static void main(String[] args) 
	{
		new Hospital();
	}
}