package com.search;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


import com.utils.DBUtil;

public class PatientSearch extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textField;
    private JButton back;
    private JButton reflash;
    private JTextArea area;

    Connection conn;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
    /**
     * Create the frame.
     */
    public PatientSearch() {
    		
		setTitle("Patient 검색");								// 패널 생성 및 크기 조절
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 993, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    JLabel lblNewLabel = new JLabel("PATIENT");				// 라벨 생성
	    lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 30));
	    lblNewLabel.setBounds(119, 27, 151, 70);
	    contentPane.add(lblNewLabel);
		
		textField = new JTextField();							// 검색 필드
		textField.setBounds(284, 38, 345, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton reflash = new JButton("F5");					// 확진자 디폴트 정보를 불러오기 위한 버튼
		reflash.setBounds(666, 120, 50,50);
		contentPane.add(reflash);
		reflash.addActionListener(this);
		
		JButton btnSearch = new JButton("Search");				// 검색 반응 버튼
		btnSearch.setBounds(666, 38, 81, 43);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				conOra();										// DB 연동 후
				patientsearch(textField.getText());				// 텍스트 필드에서 입력한 값 넘김
			}
		});

		
		JScrollPane scrollPane = new JScrollPane();				// 스크롤
		scrollPane.setBounds(78, 177, 853, 476);
		contentPane.add(scrollPane);

           
        back = new JButton("back");								// 화면으로 나가기 위한 버튼
        back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        back.setBounds(800, 38, 81, 43);
        getContentPane().add(back);
        
		area = new JTextArea();									// 확진자 정보를 띄우기 위한 필드
		area.setBounds(51, 153, 869, 470);
		scrollPane.setViewportView(area);

        setVisible(true);      
    }
    
    public void full_print(String sql) {						// 확진자 정보 표시
    	area.setText("");
    	area.append("연번\t" + "확진일\t" + "환자번호\t" + "국적\t" + "환자정보\t" + "지역\t" + "여행력\t" + "접촉력\t" + "조치사항\t" + "상태\t" + 
    	"이동경로\t" + "등록일\t" + "수정번호\t" + "노출여부" + "\n\n");
    	try {
    		rs = st.executeQuery(sql);
    		
    				while(rs.next()) {
    					String id = rs.getString("id");
    					String date = rs.getString("date");
    					String pn = rs.getString("patient_number");
    					String coun = rs.getString("country");
    					String pi = rs.getString("patient_information");
    					String local = rs.getString("local");
    					String tra = rs.getString("travel");
    					String con = rs.getString("contact");
    					String act = rs.getString("actions");
    					String state = rs.getString("state");
    					String route = rs.getString("route");
    					String rd = rs.getString("registration_date");
    					String md = rs.getString("modification_date");
    					String exp = rs.getString("exposure");
    					
    					area.append(id + "\t" + date + "\t" + pn + "\t" + coun + "\t" + pi + "\t" + local + "\t" + tra + "\t" + con
    							+ "\t" + act + "\t" + state + "\t" + route + "\t" + rd + "\t" + md + "\t" + exp + "\n");
    				}
    			} catch(Exception e) {
    				JOptionPane.showMessageDialog(this, "오류");
    				
    		} finally {
    			try {
    				if(rs != null)
    					rs.close();
    				if(st != null)
    					st.close();
    				if(conn != null)
    					conn.close();
    			} catch (Exception e) {
    				JOptionPane.showMessageDialog(this, "쓰레기값 날림");
    			}
    		}
    	
    	
    	}
   public void conOra() {										// DB 연동
	   try {
       	conn = null;
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USER_NAME, DBUtil.PWD);
			
			st = null;
			st = conn.createStatement();
			st.execute("use Observer;");

		} catch (SQLException e1) {
			System.out.println("SQLExcption : " + e1.getMessage());
			System.out.println("SQLState : " + e1.getSQLState());
			e1.printStackTrace();
		}			
	}

   	public void patientsearch(String pid) {						// 검색시 나올 정보 표시
   		area.setText("");
    	area.append("연번\t" + "확진일\t" + "환자번호\t" + "국적\t" + "환자정보\t" + "지역\t" + "여행력\t" + "접촉력\t" + "조치사항\t" + "상태\t" + 
    	"이동경로\t" + "등록일\t" + "수정번호\t" + "노출여부" + "\n\n");
   		
   		String sql = "select * from patient where patient_number like '" + pid.trim() + "'";
   		
   		try {
   			st = conn.createStatement();
   			rs = st.executeQuery(sql);
   			while(rs.next()) {
   				String id = rs.getString("id");
				String date = rs.getString("date");
				String pn = rs.getString("patient_number");
				String coun = rs.getString("country");
				String pi = rs.getString("patient_information");
				String local = rs.getString("local");
				String tra = rs.getString("travel");
				String con = rs.getString("contact");
				String act = rs.getString("actions");
				String state = rs.getString("state");
				String route = rs.getString("route");
				String rd = rs.getString("registration_date");
				String md = rs.getString("modification_date");
				String exp = rs.getString("exposure");
				
				area.append(id + "\t" + date + "\t" + pn + "\t" + coun + "\t" + pi + "\t" + local + "\t" + tra + "\t" + con
						+ "\t" + act + "\t" + state + "\t" + route + "\t" + rd + "\t" + md + "\t" + exp + "\n");
   			}
   		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "오류");
			System.out.println(e);
			
   		} finally {
   			try {
   				if(rs != null)
   					rs.close();
   				if(st != null)
   					st.close();
   				if(conn != null)
   					conn.close();
   			} catch (Exception e) {
   				JOptionPane.showMessageDialog(this, "쓰레기값 날림");
   				}
   			}
   		}

	@Override
	public void actionPerformed(ActionEvent e) {
		conOra();
		
		String sql = "select * from patient";

		full_print(sql);

		
	}
}