package com.search;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class PatientSearch extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTable table;
    private JButton back;
    private JTextArea area;
    
    ArrayList<String> list = new ArrayList<>(); 

    Connection conn;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	
    /**
     * Create the frame.
     */
    public PatientSearch() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 993, 734);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);
        
        JLabel lblNewLabel = new JLabel("PATIENT");
        lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 30));
        lblNewLabel.setBounds(119, 27, 151, 70);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(284, 38, 345, 43);
        contentPane.add(textField);
        textField.setColumns(10);
        
        area = new JTextArea();
        JScrollPane scrollpane = new JScrollPane(area);
        area.setEditable(false);
//      list.removeAll();
        
        JButton btnSearch = new JButton("search");
        btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
		        	conn = null;
					conn = DriverManager.getConnection(DBUtil.URL, DBUtil.USER_NAME, DBUtil.PWD);
					
					st = null;
					st = conn.createStatement();
					st.execute("use Observer;");
					
					String sql = "select * from patient";
					
					if(e.getSource() == btnSearch) {
						textField.setText("");
						if(textField.getText().equals("")) {} 
						else {}
					
					rs = st.executeQuery(sql);
					System.out.println("2번 try");
					
	 					while(rs.next()) {
							String str = rs.getString("id") + rs.getString("date") + rs.getString("patient_number") + rs.getString("country")
							+ rs.getString("patient_information") + rs.getString("local") + rs.getString("travel") + rs.getString("contact")
							+ rs.getString("actions") + rs.getString("state") + rs.getString("route") + rs.getString("registration_date")
							+ rs.getString("modification_date") + rs.getString("exposure");
							
							
							area.append(str);
							list.add(str);
					
	// 						String str = rs.getString(1);
	//						
	//						for(int i=0; i<str.length(); i++) {
	//							System.out.println(str);
	//						}
							
							System.out.println("str: " + str);
						}
					}
 					
 					System.out.println("list size: " + list.size());
 					
 					System.out.println("1번 try");
				} catch (SQLException e1) {
					System.out.println("SQLExcption : " + e1.getMessage());
					System.out.println("SQLState : " + e1.getSQLState());
					e1.printStackTrace();
				}			
			}
		});
        
        System.out.println(list.size());
      
        
        btnSearch.setBounds(666, 38, 81, 43);
        contentPane.add(btnSearch);
        btnSearch.setIcon(new ImageIcon("C:\\Users\\yoonh\\Desktop\\ic_search.png"));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(14, 124, 947, 551);
        contentPane.add(scrollPane);
        
        back = new JButton("back");
        
        back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	
        back.setBounds(800, 38, 70, 40);
        getContentPane().add(back);

        table = new JTable();
        
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "연번", "확진일", "환자번호", "국적", "환자정보", " 지역", "여행력", "접촉력","조치사항","상태","이동경로","등록일","수정번호","노출여부"
            }
        ));
        
        
//      area.add(list);
        scrollPane.setViewportView(table);  
        setVisible(true);
        
    }
  


     public static void main(String[] args) {
    	 PatientSearch frame = new PatientSearch();
    	 frame.setVisible(true);
     }
}