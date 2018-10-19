package manage.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ManageRightPane extends JTabbedPane {
	private JPanel welcomePane;
	private JLabel username;
	private JLabel ipLb;
	private JLabel lastLoginLb;
	private JLabel roleLb;
	
	public ManageRightPane(){
		initComponents();
		layoutComponents();
	}
	/**
	 * ��ʼ�����
	 */
	public void initComponents(){
		welcomePane = new JPanel();
		username = new JLabel("��ǰ�û���Admin");
		ipLb = new JLabel("����ip�ǣ�");
		lastLoginLb = new JLabel("��һ�ε�½��ʱ���ǣ�");
		roleLb = new JLabel("���Ľ�ɫ����������Ա");	
	}
	/**
	 * �������
	 */
	public void layoutComponents (){
		welcomePane.setLayout(new GridLayout(10, 1, 0, 5));
		welcomePane.add(username);
		welcomePane.add(ipLb);
		welcomePane.add(lastLoginLb);
		welcomePane.add(roleLb);
		addTab("��ӭ����",welcomePane);
	}
}


