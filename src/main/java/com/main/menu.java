package com.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.event.Hospital;
import com.event.Review;
import com.event.Safe;
import com.event.Self;
import com.search.DateSearch;
import com.search.LocalSearch;
import com.search.PatientSearch;


public class menu extends JFrame implements ActionListener	{

	CardLayout layout;	
	
	private JButton area = new JButton();
	private JButton date = new JButton();
	private JButton search = new JButton();
	private JButton b1 = new JButton();
	private JButton b2 = new JButton();
	private JButton b3 = new JButton();
	private JButton b4 = new JButton();
	
	private JPanel first = new JPanel(new BorderLayout());
	private JPanel fuction = new JPanel(new FlowLayout());
	private static menu me = new menu();


	public menu()
	{

		setTitle("메뉴판");	//프레임 이름 메뉴판 설정
		layout= new CardLayout();	//카드 레이아웃 할당
		setLayout(layout);	//메인 프레임 카드 레이아웃으로 설정
		
		setMainmenu();	//메인기능 화면 구성 추가
		setSubmenu();	//서브기능 화면 구성 추가
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//종료 셋팅
		setSize(890,550);	//절대 크기 조절 이미지 파일 때문에 필수
//		setVisible(true);	//항상 보여질 것 
	}
	public void actionPerformed(ActionEvent e) //메뉴 클릭시 반응 리스너 설정 메뉴판 기능을 사용하지 않으니 필요없음
	{
		JMenuItem mi = (JMenuItem) (e.getSource());	//부메뉴(아이템)클릭시 받아오기
		
		switch (mi.getText()){
		case "file":
			System.out.println("확진자 파일을 엽니다.");	//file클릭시
			break;
		case "today":
			System.out.println("오늘 확진자는 148 명입니다");	//today클릭시
			break;
		case "review":
			System.out.println("완치자 리뷰를 엽니다.");	//review클릭시
			break;
		case "number":
			System.out.println("총 완치자 수를 조회합니다.");	//number클릭시
			break;
		case "main":
			layout.first(this.getContentPane());	//메인화면으로 이동
			break;
		case "sub":
			layout.last(this.getContentPane());		//서브화면으로 이동
			break;
		}
	}
	
	public void setMainmenu() 	//메인기능 화면 구성 메소드
	{

		//이미지 경로표시 절대좌표 재설정해야함!! 중요
		ImageIcon img1 = new ImageIcon("koreaimages/지역.png");
		ImageIcon img2 = new ImageIcon("koreaimages/날짜.png");
		ImageIcon img3 = new ImageIcon("koreaimages/검색.png");
		//주기능 이미지 버튼 추가
		area = new JButton("", img1);
		
		area.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PatientSearch();	
			}
		});

		date = new JButton("", img2);
		
		date.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LocalSearch();	
			}
		});
		
		
		search = new JButton("", img3);
		
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DateSearch();	
			}
		});
		
		
		//부가기능 화면 전환 버튼 추가
		JButton nextButton = new JButton("부가기능");
		//부가기능 화면 전환시 리스너를 통해 화면 전환
		ActionListener listener1 = e -> {
			if(e.getSource() == nextButton) {
				layout.next(this.getContentPane());
			} else {
			}
		};
		nextButton.addActionListener(listener1);
		//주기능 이미지 버튼 패널에 장착
		getContentPane().add(area);
		fuction.add(area);
		fuction.add(date);
		fuction.add(search);
		//first패널에 주기능 패널 장착
		first.add(fuction, "Center");
		//first패널에 프레임에 화면전환 버튼 장착
		first.add(nextButton, "South");
		//완성된 first패널 프레임 0번에 장착
		add("0",first);
		

	}
	void setSubmenu() //부가기능 화면 구성 메소드
	{
		JPanel second = new JPanel(new BorderLayout());
		JPanel fuction = new JPanel(new GridLayout(2,2));
		//이미지 경로표시 절대좌표 재설정해야함!! 중요
		ImageIcon img1 = new ImageIcon("koreaimages/부가기능1.png");
		ImageIcon img2 = new ImageIcon("koreaimages/부가기능2.png");
		ImageIcon img3 = new ImageIcon("koreaimages/부가기능3.png");
		ImageIcon img4 = new ImageIcon("koreaimages/부가기능4.png");
		//부가기능 이미지 버튼 4개 추가
		JButton b1 = new JButton("안전수칙", img1);
		b1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new Safe();
			}
		});
		JButton b2 = new JButton("근처 병원 찾기", img2);
		b2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new Hospital();
				
			}
		});
		JButton b3 = new JButton("자가 문진표", img3);
		b3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new Self();
			}
		});
		JButton b4 = new JButton("완치자 후기", img4);
		b4.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				new Review();
			}
		});
		//메인화면 전환 버튼 추가
		JButton previousButton = new JButton("이전으로");
		//메인화면 전환버튼 클릭시 리스너를 이용해 화면 전환
		ActionListener listener1 = e -> {
			if(e.getSource() == previousButton) {
				layout.previous(this.getContentPane());
			} else {
			}
		};
		previousButton.addActionListener(listener1);
		//부가기능 이미지 버튼 4개 패널에 부착
		fuction.add(b1);
		fuction.add(b2);
		fuction.add(b3);
		fuction.add(b4);
		//부가기능 패널을  second패널에 부착
		second.add(fuction, "North");
		//메인화면 전환 버튼을 second패널에 부착
		second.add(previousButton, "South");
		//완성된 second 프레임 1번에 부착
		add("1",second);
		
	}

	
	public static void main(String[] args)	//실행 코드
	{
		me.setVisible(true);
		
	}
}

