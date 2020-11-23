package com.search;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Bar
{
    public static void main(String args[])
    
    {
        JFrame frame = new JFrame("지역별 확진자수");
        frame.setLocation(0,0);
        frame.setPreferredSize(new Dimension(1250,900));
        Container contentPane = frame.getContentPane();

        DrawingPanel drawingPanel = new DrawingPanel();
        contentPane.add(drawingPanel, BorderLayout.CENTER);
        

      
        
        //그래프를 그릴 패널

//        JPanel controlPanel = new JPanel();
//        JTextField text1 = new JTextField(3);
//        JTextField text2 = new JTextField(3);
//        JTextField text3 = new JTextField(3);
//        JButton button = new JButton("Show");
//        controlPanel.add(new JLabel("강남구"));
//        controlPanel.add(text1);
//        controlPanel.add(new JLabel("강서구"));
//        controlPanel.add(text2);
//        controlPanel.add(new JLabel("C#"));
//        controlPanel.add(text3);
//        controlPanel.add(button);
//        contentPane.add(controlPanel, BorderLayout.SOUTH);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        button.addActionListener(new DrawActionListener(text1,text2,text3,drawingPanel));
//        //"그래프 그리기" 버튼을 눌렀을때 작동 할 리스터등록
        frame.pack();
        frame.setVisible(true);
    }
    


}

//그래프를 그리는 패널 클래스
class DrawingPanel extends JPanel
{
//    int score_java, score_python, score_cs;
    public void paint(Graphics g){
        g.clearRect(0,0,getWidth(),getHeight());
        g.drawLine(50,400,2400,400);
        for(int cnt = 1 ;cnt<16;cnt++)
        {
            g.drawString(cnt *20 +"",25,405-20*cnt);
            g.drawLine(50, 400-20*cnt, 2400 ,400-20*cnt);
        }
        g.drawLine(50,20,50,400);
        g.drawString("강남구",100,420);
        g.drawString("강동구",150,420);
        g.drawString("강북구",200,420);
        g.drawString("강서구",250,420);
        g.drawString("경기광주",300,420);
        g.drawString("고양시",350,420);
        g.drawString("관악구",400,420);
        g.drawString("광명",450,420);
        g.drawString("광진구",500,420);
        g.drawString("구로구",550,420);
        g.drawString("금천구",600,420);
        g.drawString("기타",650,420);
        g.drawString("김포",700,420);
        g.drawString("남양주시",750,420);
        g.drawString("노원구",800,420);
        g.drawString("도봉구",850,420);
        g.drawString("동대문구",900,420);
        g.drawString("동작구",950,420);
        g.drawString("마포구",1000,420);
        g.drawString("부천시",1050,420);
        g.drawString("부평",1100,420);
        g.drawString("서대문구",1150,420);
        g.drawString("서초구",1200,420);
//        g.drawString("성남시",1250,420);
//        g.drawString("성동구",1300,420);
//        g.drawString("성북구",1350,420);
//        g.drawString("송파구",1400,420);
//        g.drawString("수원시",1450,420);
//        g.drawString("시흥시",1500,420);
//        g.drawString("안양시",1550,420);
//        g.drawString("안산",1600,420);
//        g.drawString("양주시",1650,420);
//        g.drawString("양천구",1700,420);
//        g.drawString("양평",1750,420);
//        g.drawString("영등포구",1800,420);
//        g.drawString("용산구",1850,420);
//        g.drawString("용인시",1900,420);
//        g.drawString("은평구",1950,420);
//        g.drawString("종로구",2000,420);
//        g.drawString("중구",2050,420);
//        g.drawString("중랑구",2100,420);
//        g.drawString("천안",2150,420);
//        g.drawString("파주",2200,420);
//        g.drawString("평택",2250,420);
//        g.drawString("포천",2300,420);
//        g.drawString("하남",2350,420);
//        g.drawString("화성",2400,420);
        
//        g.setColor(Color.BLUE);
      
        g.fillRect(110,400-208,10,208);//강남
        g.fillRect(160,400-165,10,165);//강동
        g.fillRect(210,400-125,10,125);//강북
        g.fillRect(260,400-232,10,232);//강서
        g.fillRect(310,400-4,10,4);//광주
        g.fillRect(360,400-13,10,13);//고양
        g.fillRect(410,400-278,10,278);//관악
        g.fillRect(460,400-9,10,9);//광명
        g.fillRect(510,400-109,10,109);//광진
        g.fillRect(560,400-152,10,152);//구로
        g.fillRect(610,400-76,10,76);//금천
        g.fillRect(660,400-190,10,190);//기타
        g.fillRect(710,400-5,10,5);//김포
        g.fillRect(760,400-6,10,6);//남양주시
        g.fillRect(810,400-245,10,245);//노원구
        g.fillRect(860,400-144,10,144);//도봉구
        g.fillRect(910,400-129,10,129);//동대문구
        g.fillRect(960,400-181,10,181);//동작구
        g.fillRect(1010,400-142,10,142);//마포구
        g.fillRect(1060,400-4,10,4);//부천
        g.fillRect(1110,400-1,10,1);//부평
        g.fillRect(1160,400-102,10,102);//서대문구
        g.fillRect(1210,400-156,10,156);//서초구
//        g.fillRect(1260,400-7,10,7);//성남시
//        g.fillRect(1310,400-102,10,102);//성동구
//        g.fillRect(1360,400-295,10,295);//성북구
//        g.fillRect(1410,400-270,10,270);//송파구
//        g.fillRect(1460,400-2,10,2);//수원시
//        g.fillRect(1510,400-1,10,1);//시흥시
//        g.fillRect(1560,400-4,10,4);//안양시
//        g.fillRect(1610,400-1,10,1);//안산
//        g.fillRect(1660,400-3,10,3);//양주시
//        g.fillRect(1710,400-156,10,156);//양천구
//        g.fillRect(1760,400-3,10,3);//양평
//        g.fillRect(1810,400-150,10,150);//영등포구
//        g.fillRect(1860,400-108,10,108);//용산구
//        g.fillRect(1910,400-3,10,3);//용인시
//        g.fillRect(1960,400-202,10,202);//은평구
//        g.fillRect(2010,400-2,10,2);//의정부 
//        g.fillRect(2060,400-67,10,67);//종로구
//        g.fillRect(2110,400-54,10,54);//중구
//        g.fillRect(2160,400-165,10,165);//중랑구
//        g.fillRect(2210,400-2,10,2);//천안
//        g.fillRect(2260,400-1,10,1);//파주
//        g.fillRect(2310,400-1,10,1);//평택
//        g.fillRect(2360,400-1,10,1);//포천
//        g.fillRect(2410,400-2,10,2);//하남
//        g.fillRect(2460,400-2,10,2);//화성
    
        
    g.drawLine(50,800,2400,800);
    for(int cnt = 1 ;cnt<16;cnt++)
    {
        g.drawString(cnt *20 +"",25,800-20*cnt);
        g.drawLine(50, 800-20*cnt, 2400 ,800-20*cnt);
    }
    g.drawLine(50,20,50,800);
   
    g.drawString("성남시",100,820);
    g.drawString("성동구",150,820);
    g.drawString("성북구",200,820);
    g.drawString("송파구",250,820);
    g.drawString("수원시",300,820);
    g.drawString("시흥시",350,820);
    g.drawString("안양시",400,820);
    g.drawString("안산",450,820);
    g.drawString("양주시",500,820);
    g.drawString("양천구",550,820);
    g.drawString("양평",600,820);
    g.drawString("영등포구",650,820);
    g.drawString("용산구",700,820);
    g.drawString("용인시",750,820);
    g.drawString("은평구",800,820);
    g.drawString("종로구",850,820);
    g.drawString("중구",900,820);
    g.drawString("중랑구",950,820);
    g.drawString("천안",1000,820);
    g.drawString("파주",1050,820);
    g.drawString("평택",1100,820);
    g.drawString("포천",1150,820);
    g.drawString("하남",1200,820);
    g.drawString("화성",1250,820);
    
//    g.setColor(Color.BLUE);
    
    
    g.fillRect(110,800-7,10,7);//성남시
    g.fillRect(160,800-102,10,102);//성동구
    g.fillRect(210,800-295,10,295);//성북구
    g.fillRect(260,800-270,10,270);//송파구
    g.fillRect(310,800-2,10,2);//수원시
    g.fillRect(360,800-1,10,1);//시흥시
    g.fillRect(410,800-4,10,4);//안양시
    g.fillRect(460,800-1,10,1);//안산
    g.fillRect(510,800-3,10,3);//양주시
    g.fillRect(560,800-156,10,156);//양천구
    g.fillRect(610,800-3,10,3);//양평
    g.fillRect(660,800-150,10,150);//영등포구
    g.fillRect(710,800-108,10,108);//용산구
    g.fillRect(760,800-3,10,3);//용인시
    g.fillRect(810,800-202,10,202);//은평구
    g.fillRect(860,800-2,10,2);//의정부 
    g.fillRect(910,800-67,10,67);//종로구
    g.fillRect(960,800-54,10,54);//중구
    g.fillRect(1010,800-165,10,165);//중랑구
    g.fillRect(1060,800-2,10,2);//천안
    g.fillRect(1110,800-1,10,1);//파주
    g.fillRect(1160,800-1,10,1);//평택
    g.fillRect(1210,800-1,10,1);//포천
    g.fillRect(1260,800-2,10,2);//하남
    g.fillRect(1310,800-2,10,2);//화성
}
}
        
//        if (score_java>0)
//            g.fillRect(110,250-score_java*2,10,score_java*2);
//        if(score_python>0)
//            g.fillRect(210,250-score_python*2,10,score_python*2);
//        if(score_cs>0)
//            g.fillRect(310,250-score_cs*2,10,score_cs*2);
//    }
//    void setScores(int score_java, int score_python, int score_cs)
//    {
//        this.score_java=score_java;
//        this.score_python=score_python;
//        this.score_cs=score_cs;
//    }
//}

//버튼 눌렀을때 동작하는 리스너
//class DrawActionListener implements ActionListener
//{
//    JTextField text1,text2,text3;
//    DrawingPanel drawingPanel;
//    DrawActionListener(JTextField text1, JTextField text2, JTextField text3, DrawingPanel drawingPanel)
//    {
//        this.text1=text1;
//        this.text2=text2;
//        this.text3=text3;
//        this.drawingPanel = drawingPanel;
//    }
//    public void actionPerformed(ActionEvent e)
//    {
//        try
//        {
//            int korean = Integer.parseInt(text1.getText());
//            int english = Integer.parseInt(text2.getText());
//            int math = Integer.parseInt(text3.getText());
//            drawingPanel.setScores(korean, english, math);
//            drawingPanel.repaint();
//        }
//        catch (NumberFormatException nfe){
//            JOptionPane.showMessageDialog(drawingPanel,"잘못된 숫자 입력입니다","에러메시지",JOptionPane.ERROR_MESSAGE);
//        }
//    }
//}