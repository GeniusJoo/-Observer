import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class menu extends JFrame implements ActionListener	
{
	CardLayout layout;	//ī�巹�̾ƿ����� �ֱ��ȭ��, �ΰ���� ȭ�� ��ȯ���� 
	menu()
	{
		setTitle("�޴���");	//������ �̸� �޴��� ����
		layout= new CardLayout();	//ī�� ���̾ƿ� �Ҵ�
		setLayout(layout);	//���� ������ ī�� ���̾ƿ����� ����
		
		/*ȭ�鿡 �޴��� �߰� ���� �ʿ������ �ּ� ó��
		JMenuItem item;	//�޴� ������
		
		JMenuBar mb = new JMenuBar();	//�޴���
		
		JMenu m1 = new JMenu("Ȯ����");	//�ָ޴�1
		JMenu m2 = new JMenu("��ġ��");	//�ָ޴�2
		JMenu m3 = new JMenu("ȭ�� �̵�");	//�ָ޴�3
		
		//Ȯ���� �޴��� �θ޴�(������) �߰�
		item = new JMenuItem("file");
		item.addActionListener(this);
		m1.add(item);
		item = new JMenuItem("today");
		item.addActionListener(this);
		m1.add(item);
		m1.addSeparator();
		m1.add(new JMenuItem("����"));
		//��ġ�� �޴��� �θ޴�(������) �߰�
		item = new JMenuItem("review");
		item.addActionListener(this);
		m2.add(item);
		item = new JMenuItem("number");
		item.addActionListener(this);
		m2.add(item);
		m2.addSeparator();
		m2.add(new JMenuItem("����"));
		//ȭ�� �̵� �޴��� �θ޴�(������) �߰�
		item = new JMenuItem("main");
		item.addActionListener(this);
		m3.add(item);
		item = new JMenuItem("sub");
		item.addActionListener(this);
		m3.add(item);
		m3.addSeparator();
		m3.add(new JMenuItem("����"));
		//�θ޴� �߰� ��
		mb.add(m1);	//�޴��ǿ� �ָ޴�1 ����
		mb.add(m2);	//�޴��ǿ� �ָ޴�2 ����
		mb.add(m3);	//�޴��ǿ� �ָ޴�3 ����
		setJMenuBar(mb);	//�޴��� ����
		ȭ�鿡 �޴��� �߰� �� */
		
		setMainmenu();	//���α�� ȭ�� ���� �߰�
		setSubmenu();	//������ ȭ�� ���� �߰�
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//���� ����
		setSize(890,550);	//���� ũ�� ���� �̹��� ���� ������ �ʼ�
		setVisible(true);	//�׻� ������ �� 
	}
	public void actionPerformed(ActionEvent e) //�޴� Ŭ���� ���� ������ ���� �޴��� ����� ������� ������ �ʿ����
	{
		JMenuItem mi = (JMenuItem) (e.getSource());	//�θ޴�(������)Ŭ���� �޾ƿ���
		
		switch (mi.getText()){
		case "file":
			System.out.println("Ȯ���� ������ ���ϴ�.");	//fileŬ����
			break;
		case "today":
			System.out.println("���� Ȯ���ڴ� 148 ���Դϴ�");	//todayŬ����
			break;
		case "review":
			System.out.println("��ġ�� ���並 ���ϴ�.");	//reviewŬ����
			break;
		case "number":
			System.out.println("�� ��ġ�� ���� ��ȸ�մϴ�.");	//numberŬ����
			break;
		case "main":
			layout.first(this.getContentPane());	//����ȭ������ �̵�
			break;
		case "sub":
			layout.last(this.getContentPane());		//����ȭ������ �̵�
			break;
		}
	}
	
	void setMainmenu() 	//���α�� ȭ�� ���� �޼ҵ�
	{
		JPanel first = new JPanel(new BorderLayout());
		JPanel fuction = new JPanel(new FlowLayout());
		//�̹��� ���ǥ�� ������ǥ �缳���ؾ���!! �߿�
		ImageIcon img1 = new ImageIcon("C:/Users/JungJooYoung/Desktop/�� �׸�����/����.png");
		ImageIcon img2 = new ImageIcon("C:/Users/JungJooYoung/Desktop/�� �׸�����/��¥.png");
		ImageIcon img3 = new ImageIcon("C:/Users/JungJooYoung/Desktop/�� �׸�����/�˻�.png");
		//�ֱ�� �̹��� ��ư �߰�
		JButton area = new JButton("", img1);
		JButton date = new JButton("", img2);
		JButton search = new JButton("", img3);
		//�ΰ���� ȭ�� ��ȯ ��ư �߰�
		JButton nextButton = new JButton("�ΰ����");
		//�ΰ���� ȭ�� ��ȯ�� �����ʸ� ���� ȭ�� ��ȯ
		ActionListener listener1 = e -> {
			if(e.getSource() == nextButton) {
				layout.next(this.getContentPane());
			} else {
			}
		};
		nextButton.addActionListener(listener1);
		//�ֱ�� �̹��� ��ư �гο� ����
		fuction.add(area);
		fuction.add(date);
		fuction.add(search);
		//first�гο� �ֱ�� �г� ����
		first.add(fuction, "Center");
		//first�гο� �����ӿ� ȭ����ȯ ��ư ����
		first.add(nextButton, "South");
		//�ϼ��� first�г� ������ 0���� ����
		add("0",first);
	}
	void setSubmenu() //�ΰ���� ȭ�� ���� �޼ҵ�
	{
		JPanel second = new JPanel(new BorderLayout());
		JPanel fuction = new JPanel(new GridLayout(2,2));
		//�̹��� ���ǥ�� ������ǥ �缳���ؾ���!! �߿�
		ImageIcon img1 = new ImageIcon("C:/Users/JungJooYoung/Desktop/�� �׸�����/�ΰ����1.png");
		ImageIcon img2 = new ImageIcon("C:/Users/JungJooYoung/Desktop/�� �׸�����/�ΰ����2.png");
		ImageIcon img3 = new ImageIcon("C:/Users/JungJooYoung/Desktop/�� �׸�����/�ΰ����3.png");
		ImageIcon img4 = new ImageIcon("C:/Users/JungJooYoung/Desktop/�� �׸�����/�ΰ����4.png");
		//�ΰ���� �̹��� ��ư 4�� �߰�
		JButton b1 = new JButton("", img1);
		JButton b2 = new JButton("", img2);
		JButton b3 = new JButton("", img3);
		JButton b4 = new JButton("", img4);
		//����ȭ�� ��ȯ ��ư �߰�
		JButton previousButton = new JButton("��������");
		//����ȭ�� ��ȯ��ư Ŭ���� �����ʸ� �̿��� ȭ�� ��ȯ
		ActionListener listener1 = e -> {
			if(e.getSource() == previousButton) {
				layout.previous(this.getContentPane());
			} else {
			}
		};
		previousButton.addActionListener(listener1);
		//�ΰ���� �̹��� ��ư 4�� �гο� ����
		fuction.add(b1);
		fuction.add(b2);
		fuction.add(b3);
		fuction.add(b4);
		//�ΰ���� �г���  second�гο� ����
		second.add(fuction, "North");
		//����ȭ�� ��ȯ ��ư�� second�гο� ����
		second.add(previousButton, "South");
		//�ϼ��� second ������ 1���� ����
		add("1",second);
	}
	public static void main(String[] args)	//���� �ڵ�
	{
		new menu();
	}
}

