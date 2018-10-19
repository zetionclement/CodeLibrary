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
	 * 初始化组件
	 */
	public void initComponents(){
		welcomePane = new JPanel();
		username = new JLabel("当前用户：Admin");
		ipLb = new JLabel("您的ip是：");
		lastLoginLb = new JLabel("上一次登陆的时间是：");
		roleLb = new JLabel("您的角色：超级管理员");	
	}
	/**
	 * 组件布局
	 */
	public void layoutComponents (){
		welcomePane.setLayout(new GridLayout(10, 1, 0, 5));
		welcomePane.add(username);
		welcomePane.add(ipLb);
		welcomePane.add(lastLoginLb);
		welcomePane.add(roleLb);
		addTab("欢迎界面",welcomePane);
	}
}


