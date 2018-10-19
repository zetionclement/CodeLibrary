package manage.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import manage.ui.customerPane.CustomerPane;
import manage.ui.medicinePane.MedicinePane;
import manange.ui.bingliPane.BingliPane;
import manange.ui.doctorPane.DoctorPane;
import manange.ui.loginPane.LoginPane;

public class ManageLeftPane extends JPanel implements ActionListener {
	private JButton doctorBtn;
	private JButton customerBtn;
	private JButton bingliBtn;
	private JButton medicinesBtn;
	private JButton loginBtn;
	private ManageRightPane rightPane = new ManageRightPane();
	/**
	 * Create the panel.
	 * @param rightPane 
	 */
	public ManageLeftPane(ManageRightPane rightPane) {

		this.rightPane = rightPane;
		
		JPanel leftPane = new JPanel();
		add(leftPane);
		leftPane.setLayout(new GridLayout(10, 1, 0, 5));

		doctorBtn = new JButton("医生管理");  
		leftPane.add(doctorBtn);
		customerBtn = new JButton("客户管理");  
		leftPane.add(customerBtn);
		bingliBtn = new JButton("病例管理"); 
		leftPane.add(bingliBtn);
		medicinesBtn = new JButton("药品管理");  
		leftPane.add(medicinesBtn);
		loginBtn = new JButton("登陆管理");
		leftPane.add(loginBtn);

		// 注册监听器
		addListeners();

	}
	/**
	 * 添加事件监听器
	 */
	public void addListeners() {
		doctorBtn.addActionListener(this);
		customerBtn.addActionListener(this);
		bingliBtn.addActionListener(this);
		medicinesBtn.addActionListener(this);
		loginBtn.addActionListener(this);
	}
	/**
	 * 触发事件
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == doctorBtn) {
			open("医生管理", new DoctorPane());
		} else if (e.getSource() == customerBtn) {
			open("客户管理", new CustomerPane());
		} else if (e.getSource() == bingliBtn) {
			open("病例管理", new BingliPane());
		} else if (e.getSource() == medicinesBtn) {
			open("药品管理", new MedicinePane());
		} else if(e.getSource() == loginBtn) {
			open("登陆管理", new LoginPane());
		}
		
	}
	public void open(String tabTitle, JComponent comp) {
		// 判断面板是否存在
		if (rightPane.indexOfTab(tabTitle) == -1) {// 面板不存在
			rightPane.addTab(tabTitle, comp);
		} else {
			int index = rightPane.indexOfTab(tabTitle);// 获得面板的下标
			rightPane.setSelectedIndex(index);// 让该面板选中
		}
	}
}
