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

		doctorBtn = new JButton("ҽ������");  
		leftPane.add(doctorBtn);
		customerBtn = new JButton("�ͻ�����");  
		leftPane.add(customerBtn);
		bingliBtn = new JButton("��������"); 
		leftPane.add(bingliBtn);
		medicinesBtn = new JButton("ҩƷ����");  
		leftPane.add(medicinesBtn);
		loginBtn = new JButton("��½����");
		leftPane.add(loginBtn);

		// ע�������
		addListeners();

	}
	/**
	 * ����¼�������
	 */
	public void addListeners() {
		doctorBtn.addActionListener(this);
		customerBtn.addActionListener(this);
		bingliBtn.addActionListener(this);
		medicinesBtn.addActionListener(this);
		loginBtn.addActionListener(this);
	}
	/**
	 * �����¼�
	 */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == doctorBtn) {
			open("ҽ������", new DoctorPane());
		} else if (e.getSource() == customerBtn) {
			open("�ͻ�����", new CustomerPane());
		} else if (e.getSource() == bingliBtn) {
			open("��������", new BingliPane());
		} else if (e.getSource() == medicinesBtn) {
			open("ҩƷ����", new MedicinePane());
		} else if(e.getSource() == loginBtn) {
			open("��½����", new LoginPane());
		}
		
	}
	public void open(String tabTitle, JComponent comp) {
		// �ж�����Ƿ����
		if (rightPane.indexOfTab(tabTitle) == -1) {// ��岻����
			rightPane.addTab(tabTitle, comp);
		} else {
			int index = rightPane.indexOfTab(tabTitle);// ��������±�
			rightPane.setSelectedIndex(index);// �ø����ѡ��
		}
	}
}
