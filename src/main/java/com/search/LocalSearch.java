package com.search;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Choice;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocalSearch extends JFrame {
		
		private JPanel contentPane;
		private JTextField textField;
		private JTable table;
		
			
		public LocalSearch() {
			setTitle("지역 검색");
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
			
			JButton SearchButton = new JButton("search");
			SearchButton.setBounds(666, 38, 81, 43);
			contentPane.add(SearchButton);
			
			Container c = getContentPane();
			
			String[] korea = {"대한민국", "서울", "경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주도"};
//			final ImageIcon[] koreaImage = {new ImageIcon("koreaimages/남한 사진.jpg"), new ImageIcon("koreaimages/서울.jpg"),
//					new ImageIcon("koreaimages/경기도.jpg"), new ImageIcon("koreaimages/강원도.jpg"), new ImageIcon("koreaimages/충청북도.jpg"), 
//					new ImageIcon("koreaimages/충청남도.jpg"), new ImageIcon("koreaimages/전라북도.jpg"), new ImageIcon("koreaimages/전라남도.jpg"),
//					new ImageIcon("koreaimages/경상북도.jpg"), new ImageIcon("koreaimages/경상남도.jpg"), new ImageIcon("koreaimages/제주도.jpg") 
//					};
//			final JLabel koreaImageLabel = new JLabel(koreaImage[0]);
			
			JComboBox SearchLocalComboBox = new JComboBox(korea);
		
//			SearchLocalComboBox.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					JComboBox findComboBox = (JComboBox)e.getSource();
//					int index = findComboBox.getSelectedIndex();
//					koreaImageLabel.setIcon(koreaImage[index]);	
//				}
//			});
			
			c.add(SearchLocalComboBox);
//			c.add(koreaImageLabel);
			
			SearchLocalComboBox.setBounds(800, 38, 81, 43);
			SearchLocalComboBox.setVisible(true);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(14, 124, 947, 551);
			contentPane.add(scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"연번", "확진일", "환자번호", "국적", "환자정보", " 지역", "여행력", "접촉력","조치사항","상태","이동경로","등록일","수정번호","노출여부"
				}
			));
			scrollPane.setViewportView(table);
			
			JLabel LocalLabel = new JLabel("지역 검색");
			LocalLabel.setFont(new Font("함초롬돋움", Font.BOLD, 30));
			LocalLabel.setBounds(119, 28, 151, 70);
			contentPane.add(LocalLabel);
		}
		 public static void main(String[] args) {
			 LocalSearch frame = new LocalSearch();
			frame.setVisible(true);
	     }
	}