package manage.ui.customerPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.ServerException;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.Customer;
import server.service.IMgCustomerService;
import server.service.impl.MgCustomerServiceImpl;
import util.DateChooserUtils;
import util.DateUtils;

public class CustomerAddDialog extends JDialog {
	private IMgCustomerService cs = new MgCustomerServiceImpl();
	private DateChooserUtils dateChooser = DateChooserUtils.getInstance("yyyy-MM-dd");
	private JTextField customerNoJt;
	private JTextField customerNameJt;
	private JTextField customerageJt;
	private JTextField customerphoneJt;
	private JTextField brithDateJt;
	private JTextField pcardJt;
	private JTextField addressJt;
	private JTextField roomIDJt;
	private JRadioButton manRB;
	private JRadioButton womenRB;
	private CustomerPane cp;
	
	/**
	 * Create the dialog.
	 */
	public CustomerAddDialog(CustomerPane cp) {
		this.cp = cp;
		setModal(true);//�Ѵ�������Ϊģ̬
		setResizable(false);//�û������϶���С
		setTitle("��ӿͻ�");
		setBounds(100, 100, 352, 700);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton okBtn = new JButton("\u786E\u5B9A");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		okBtn.setActionCommand("OK");
		okBtn.setBounds(89, 600, 69, 23);
		panel.add(okBtn);
		
		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		resetBtn.setActionCommand("Cancel");
		resetBtn.setBounds(182, 600, 69, 23);
		panel.add(resetBtn);
		
		JLabel customerNoJl = new JLabel("�ͻ����:");
		customerNoJl.setHorizontalAlignment(SwingConstants.RIGHT);
		customerNoJl.setBounds(36, 29, 79, 15);
		panel.add(customerNoJl);
		
		customerNoJt = new JTextField();
		customerNoJt.setColumns(4);
		customerNoJt.setBounds(134, 26, 136, 21);
		panel.add(customerNoJt);
		
		JLabel customerNameJl = new JLabel("�ͻ�����:");
		customerNameJl.setHorizontalAlignment(SwingConstants.RIGHT);
		customerNameJl.setBounds(36, 70, 79, 15);
		panel.add(customerNameJl);
		
		customerNameJt = new JTextField();
		customerNameJt.setColumns(3);
		customerNameJt.setBounds(134, 67, 136, 21);
		panel.add(customerNameJt);
		
		JLabel sexJl = new JLabel("�Ա�:");
		sexJl.setHorizontalAlignment(SwingConstants.RIGHT);
		sexJl.setBounds(36, 115, 79, 15);
		panel.add(sexJl);
		
		JLabel customerageJl = new JLabel("����:");
		customerageJl.setHorizontalAlignment(SwingConstants.RIGHT);
		customerageJl.setBounds(36, 163, 79, 15);
		panel.add(customerageJl);
		
		customerageJt = new JTextField();
		customerageJt.setColumns(2);
		customerageJt.setBounds(134, 160, 136, 21);
		panel.add(customerageJt);
		

		
		JLabel brithJl = new JLabel("��������:");
		brithJl.setHorizontalAlignment(SwingConstants.RIGHT);
		brithJl.setBounds(36, 209, 79, 15);
		panel.add(brithJl);
		
		brithDateJt = new JTextField();
		brithDateJt.setEditable(false);
		dateChooser.register(brithDateJt);
		brithDateJt.setColumns(10);
		brithDateJt.setBounds(134, 206, 136, 21);
		panel.add(brithDateJt);
		
		JLabel pcardJl = new JLabel("���֤��:");
		pcardJl.setHorizontalAlignment(SwingConstants.RIGHT);
		pcardJl.setBounds(36, 254, 79, 15);
		panel.add(pcardJl);
		
		pcardJt = new JTextField();
		pcardJt.setColumns(18);
		pcardJt.setBounds(134, 251, 136, 21);
		panel.add(pcardJt);
		
		
		JLabel customerphoneJl = new JLabel("�绰:");
		customerphoneJl.setHorizontalAlignment(SwingConstants.RIGHT);
		customerphoneJl.setBounds(36, 299, 79, 15);
		panel.add(customerphoneJl);
		
		customerphoneJt = new JTextField();
		customerphoneJt.setColumns(11);
		customerphoneJt.setBounds(134, 296, 136, 21);
		panel.add(customerphoneJt);
		
		
		JLabel addressJl = new JLabel("סַ:");
		addressJl.setHorizontalAlignment(SwingConstants.RIGHT);
		addressJl.setBounds(36, 344, 79, 15);
		panel.add(addressJl);
		
		addressJt = new JTextField();
		addressJt.setColumns(2);
		addressJt.setBounds(134, 341, 136, 21);
		panel.add(addressJt);
		
		JLabel roomIDJl = new JLabel("������:");
		roomIDJl.setHorizontalAlignment(SwingConstants.RIGHT);
		roomIDJl.setBounds(36, 389, 79, 15);
		panel.add(roomIDJl);
		
		roomIDJt = new JTextField();
		roomIDJt.setColumns(2);
		roomIDJt.setBounds(134, 386, 136, 21);
		panel.add(roomIDJt);
		
		manRB = new JRadioButton("\u7537");
		manRB.setBounds(134, 111, 54, 23);
		manRB.setSelected(true);
		panel.add(manRB);
		
		womenRB = new JRadioButton("\u5973");
		womenRB.setBounds(197, 111, 54, 23);
		panel.add(womenRB);
		ButtonGroup bg = new ButtonGroup(); // ������ť�����
		bg.add(manRB);
		bg.add(womenRB);
		
		
		

	}
	/**
	 * ���÷���
	 */
	public void reset(){
		customerNoJt.setText("");
		customerNameJt.setText("");
		manRB.setSelected(true);
		customerageJt.setText("");
		brithDateJt.setText("");
		pcardJt.setText("");
		customerphoneJt.setText("");
		addressJt.setText("");
		roomIDJt.setText("");
	}
	/**
	 * ���Ա��
	 */
	public void add(){
		Customer ce = new Customer();
		if(null == customerNoJt.getText() || "".equals(customerNoJt.getText())){
			JOptionPane.showMessageDialog(this, "�ͻ���Ų���Ϊ�գ�");
		}else if(null == customerNameJt.getText() || "".equals(customerNameJt.getText())){
			JOptionPane.showMessageDialog(this, "�ͻ����ֲ���Ϊ�գ�");
		}else if(null == customerageJt.getText() || "".equals(customerageJt.getText())){
			JOptionPane.showMessageDialog(this, "���䲻��Ϊ�գ�");
		}else if(null == pcardJt.getText() || "".equals(pcardJt.getText())){
			JOptionPane.showMessageDialog(this, "���֤�Ų���Ϊ�գ�");
		}else if(null == customerphoneJt.getText() || "".equals(customerphoneJt.getText())){
			JOptionPane.showMessageDialog(this, "�绰����Ϊ�գ�");
		}else if(null == addressJt.getText() || "".equals(addressJt.getText())){
			JOptionPane.showMessageDialog(this, "��ַ����Ϊ�գ�");	
		}else if(null == brithDateJt.getText() || "".equals(brithDateJt.getText())){
			JOptionPane.showMessageDialog(this, "�������ڲ���Ϊ�գ�");	
		}else {
			String sex = "��";
			if(womenRB.isSelected()){
				sex = "Ů";
			}
			Date hireDate = DateUtils.getDate(brithDateJt.getText());
			int age = Integer.valueOf(customerageJt.getText());
			
			ce.setCustomerName(customerNameJt.getText());
			ce.setCustomerNo(customerNoJt.getText());
			ce.setAge(age);
			ce.setCustomerTel(customerphoneJt.getText());
			ce.setCustomerBoth(hireDate);
			ce.setCustomerPcard(pcardJt.getText());
			ce.setCustomerAddress(addressJt.getText());
			ce.setCustomerRoomID(roomIDJt.getText());
			ce.setCustomerSex(sex);

			try {
				cs.add(ce);
				JOptionPane.showMessageDialog(this, "��ӳɹ���");
				dispose();
				cp.reflesh();
			} catch (ServerException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

}
