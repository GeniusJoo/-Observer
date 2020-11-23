package com.roadjava.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.utils.DBUtil;

public class test extends JPanel implements ActionListener{
	
	private JPanel contentPane;
	private JTextArea area;
	private JButton btnSearch;

	Connection conn;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
	public test() {
		this.setLayout(new BorderLayout());
		
		contentPane = new JPanel();
		btnSearch = new JButton();
		
		contentPane.add(btnSearch);
		
		area = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(area);
		contentPane.add(scrollPane);

		this.add("Center", area);
		this.add("North", contentPane);
		
		btnSearch.addActionListener(this);
		
	}

	
    public void full_print(String sql) {
    	area.setText("");
    	area.append("연번\t" + "확진일\t" + "환자번호\t" + "국적\t" + "환자정보\t" + "지역\t" + "여행력\t" + "접촉력\t" + "조치사항\t" + "상태\t" + 
    	"이동경로\t" + "등록일\t" + "수정번호\t" + "노출여부\n\n");
    	try {
    		rs = st.executeQuery(sql);
    		System.out.println("2번 try");
    		
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
   public void conOra() {
	   try {
       	conn = null;
			conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USER_NAME, DBUtil.PWD);
			
			st = null;
			st = conn.createStatement();
			st.execute("use Observer;");
		
			
//			if(e.getSource() == btnSearch) {
//				textField.setText("");
//				if(textField.getText().equals("")) {} 
//				else {}			
			
			
			System.out.println("1번 try");
		} catch (SQLException e1) {
			System.out.println("SQLExcption : " + e1.getMessage());
			System.out.println("SQLState : " + e1.getSQLState());
			e1.printStackTrace();
		}			
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		conOra();
		
		String sql = "select * from patient";
		
		if(e.getSource() == btnSearch) {
			
			full_print(sql);
		}
		
	}
	public static void fm() {
		JFrame frame = new JFrame("gg");
		
		test tt = new test();
		frame.getContentPane().add(tt,"Center");
		frame.setSize(320, 500);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		fm();
	}
}

//String[] korea = {"", "", "", "", "", "", "", "", "", "", ""};
//final ImageIcon[] koreaImage = {new ImageIcon("koreaimages/남한 사진.jpg"), new ImageIcon("koreaimages/서울.jpg"),
//		new ImageIcon("koreaimages/경기도.jpg"), new ImageIcon("koreaimages/강원도.jpg"), new ImageIcon("koreaimages/충청북도.jpg"), 
//		new ImageIcon("koreaimages/충청남도.jpg"), new ImageIcon("koreaimages/전라북도.jpg"), new ImageIcon("koreaimages/전라남도.jpg"),
//		new ImageIcon("koreaimages/경상북도.jpg"), new ImageIcon("koreaimages/경상남도.jpg"), new ImageIcon("koreaimages/제주도.jpg") 
//		};
//final JLabel koreaImageLabel = new JLabel(koreaImage[0]);

//JComboBox SearchLocalComboBox = new JComboBox(korea);

//SearchLocalComboBox.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		JComboBox findComboBox = (JComboBox)e.getSource();
//		int index = findComboBox.getSelectedIndex();
//		koreaImageLabel.setIcon(koreaImage[index]);	
//	}
//});

//c.add(SearchLocalComboBox);
//c.add(koreaImageLabel);
//
//SearchLocalComboBox.setBounds(800, 38, 81, 43);
//SearchLocalComboBox.setVisible(true);
