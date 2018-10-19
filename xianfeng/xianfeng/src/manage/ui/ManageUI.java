package manage.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ManageUI extends JFrame {
	private CenterPane contentPane;
	private BottomPane bottomPane;
	
	public ManageUI(){
		setTitle("��̨����");  
		setLocation(50, 150);
		setResizable(false);//�û������϶���С
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 650);
		initComponents();
		layoutComponents();
	}
	/**
	 * ��ʼ�����
	 */
	public void initComponents(){
		contentPane = new CenterPane();
		bottomPane = new BottomPane();
	}
	/**
	 * �������
	 */
	public void layoutComponents (){
		getContentPane().add(bottomPane,BorderLayout.SOUTH);
		getContentPane().add(contentPane);
	}

}
