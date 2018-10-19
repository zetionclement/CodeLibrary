package manage.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ManageUI extends JFrame {
	private CenterPane contentPane;
	private BottomPane bottomPane;
	
	public ManageUI(){
		setTitle("后台管理");  
		setLocation(50, 150);
		setResizable(false);//用户不能拖动大小
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 650);
		initComponents();
		layoutComponents();
	}
	/**
	 * 初始化组件
	 */
	public void initComponents(){
		contentPane = new CenterPane();
		bottomPane = new BottomPane();
	}
	/**
	 * 组件布局
	 */
	public void layoutComponents (){
		getContentPane().add(bottomPane,BorderLayout.SOUTH);
		getContentPane().add(contentPane);
	}

}
