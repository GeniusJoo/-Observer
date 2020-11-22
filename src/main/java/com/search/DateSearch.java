package com.search;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.main.menu;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DateSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton back;

	/**
	 * Create the frame.
	 */
	public DateSearch() {
		setTitle("DATE 검색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 993, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(284, 38, 345, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setBounds(666, 38, 81, 43);
		contentPane.add(btnSearch);
		//btnSearch.setIcon(new ImageIcon("C:\\Users\\home\\OneDrive\\바탕 화면\\검색사진\\sss.png"));
		
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
	    contentPane.add(back);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"연번", "확진일", "환자번호", "국적", "환자정보", " 지역", "여행력", "접촉력","조치사항","상태","이동경로","등록일","수정번호","노출여부"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel(" D A T E");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 30));
		lblNewLabel.setBounds(119, 27, 151, 70);
		contentPane.add(lblNewLabel);
		
		setVisible(true);

	}
	

	
	 public static void main(String[] args) {
		 DateSearch frame = new DateSearch();
		 frame.setVisible(true);
     }
}