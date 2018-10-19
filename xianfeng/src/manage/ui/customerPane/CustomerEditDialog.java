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
import manange.ui.doctorPane.DoctorPane;
import server.service.IMgCustomerService;
import server.service.impl.MgCustomerServiceImpl;
import util.DateChooserUtils;
import util.DateUtils;

public class CustomerEditDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4578276150661105537L;
	private final JPanel contentPanel = new JPanel();
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
	private Customer ce;
	private CustomerPane cp;

	/**
	 * Create the dialog.
	 */
	public CustomerEditDialog(Customer ce, CustomerPane cp) {
		this.ce = ce;
		this.cp = cp;
		setModal(true);//把窗口设置为模态
		setResizable(false);//用户不能拖动大小
		setTitle("修改客户");
		setBounds(100, 100, 352, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton okBtn = new JButton("\u786E\u5B9A");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		okBtn.setActionCommand("OK");
		okBtn.setBounds(89, 600, 69, 23);
		contentPanel.add(okBtn);
		
		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		resetBtn.setActionCommand("Cancel");
		resetBtn.setBounds(182, 600, 69, 23);
		contentPanel.add(resetBtn);
		
		JLabel customerNoJl = new JLabel("客户编号:");
		customerNoJl.setHorizontalAlignment(SwingConstants.RIGHT);
		customerNoJl.setBounds(36, 29, 79, 15);
		contentPanel.add(customerNoJl);
		
		customerNoJt = new JTextField();
		customerNoJt.setColumns(4);
		customerNoJt.setBounds(134, 26, 136, 21);
		contentPanel.add(customerNoJt);
		
		JLabel customerNameJl = new JLabel("客户姓名:");
		customerNameJl.setHorizontalAlignment(SwingConstants.RIGHT);
		customerNameJl.setBounds(36, 70, 79, 15);
		contentPanel.add(customerNameJl);
		
		customerNameJt = new JTextField();
		customerNameJt.setColumns(3);
		customerNameJt.setBounds(134, 67, 136, 21);
		contentPanel.add(customerNameJt);
		
		JLabel sexJl = new JLabel("性别:");
		sexJl.setHorizontalAlignment(SwingConstants.RIGHT);
		sexJl.setBounds(36, 115, 79, 15);
		contentPanel.add(sexJl);
		
		JLabel customerageJl = new JLabel("年龄:");
		customerageJl.setHorizontalAlignment(SwingConstants.RIGHT);
		customerageJl.setBounds(36, 163, 79, 15);
		contentPanel.add(customerageJl);
		
		customerageJt = new JTextField();
		customerageJt.setColumns(2);
		customerageJt.setBounds(134, 160, 136, 21);
		contentPanel.add(customerageJt);
		

		
		JLabel brithJl = new JLabel("出生日期:");
		brithJl.setHorizontalAlignment(SwingConstants.RIGHT);
		brithJl.setBounds(36, 209, 79, 15);
		contentPanel.add(brithJl);
		
		brithDateJt = new JTextField();
		brithDateJt.setEditable(false);
		dateChooser.register(brithDateJt);
		brithDateJt.setColumns(10);
		brithDateJt.setBounds(134, 206, 136, 21);
		contentPanel.add(brithDateJt);
		
		JLabel pcardJl = new JLabel("身份证号:");
		pcardJl.setHorizontalAlignment(SwingConstants.RIGHT);
		pcardJl.setBounds(36, 254, 79, 15);
		contentPanel.add(pcardJl);
		
		pcardJt = new JTextField();
		pcardJt.setColumns(18);
		pcardJt.setBounds(134, 251, 136, 21);
		contentPanel.add(pcardJt);
		
		
		JLabel customerphoneJl = new JLabel("电话:");
		customerphoneJl.setHorizontalAlignment(SwingConstants.RIGHT);
		customerphoneJl.setBounds(36, 299, 79, 15);
		contentPanel.add(customerphoneJl);
		
		customerphoneJt = new JTextField();
		customerphoneJt.setColumns(11);
		customerphoneJt.setBounds(134, 296, 136, 21);
		contentPanel.add(customerphoneJt);
		
		
		JLabel addressJl = new JLabel("住址:");
		addressJl.setHorizontalAlignment(SwingConstants.RIGHT);
		addressJl.setBounds(36, 344, 79, 15);
		contentPanel.add(addressJl);
		
		addressJt = new JTextField();
		addressJt.setColumns(2);
		addressJt.setBounds(134, 341, 136, 21);
		contentPanel.add(addressJt);
		
		JLabel roomIDJl = new JLabel("病房号:");
		roomIDJl.setHorizontalAlignment(SwingConstants.RIGHT);
		roomIDJl.setBounds(36, 389, 79, 15);
		contentPanel.add(roomIDJl);
		
		roomIDJt = new JTextField();
		roomIDJt.setColumns(2);
		roomIDJt.setBounds(134, 386, 136, 21);
		contentPanel.add(roomIDJt);
		
		manRB = new JRadioButton("\u7537");
		manRB.setBounds(134, 111, 54, 23);
		manRB.setSelected(true);
		contentPanel.add(manRB);
		
		womenRB = new JRadioButton("\u5973");
		womenRB.setBounds(197, 111, 54, 23);
		contentPanel.add(womenRB);
		ButtonGroup bg = new ButtonGroup(); // 创建按钮组对象
		bg.add(manRB);
		bg.add(womenRB);
		
		showInfo();
	}
	/**
	 * 重置
	 */
	public void reset(){
		customerNoJt.setText("");
		customerNoJt.setText("");
		manRB.setSelected(true);
		customerageJt.setText("");
		customerphoneJt.setText("");
		brithDateJt.setText("");
		pcardJt.setText("");
		addressJt.setText("");
		roomIDJt.setText("");
	}
	/**
	 * 显示方法
	 */
	public void showInfo(){
		
		String sex = ce.getCustomerSex();
		String brithDate = DateUtils.getDateStr(ce.getCustomerBoth());
		
		String age = String.valueOf(ce.getAge());
		
		customerNoJt.setText(ce.getCustomerNo());
		customerNameJt.setText(ce.getCustomerName());
		customerageJt.setText(age);
		pcardJt.setText(ce.getCustomerPcard());
		customerphoneJt.setText(ce.getCustomerTel());
		brithDateJt.setText(brithDate);
		addressJt.setText(ce.getCustomerAddress());
		roomIDJt.setText(ce.getCustomerRoomID());


		
		if("男".equals(sex)){
			manRB.setSelected(true);
		}else{
			womenRB.setSelected(true);
		}
	}
	/**
	 * 修改方法
	 */
	public void edit(){
		if(null == customerNoJt.getText() || "".equals(customerNoJt.getText())){
			JOptionPane.showMessageDialog(this, "客户编号不能为空！");
		}else if(null == customerNameJt.getText() || "".equals(customerNameJt.getText())){
			JOptionPane.showMessageDialog(this, "客户名字不能为空！");
		}else if(null == customerageJt.getText() || "".equals(customerageJt.getText())){
			JOptionPane.showMessageDialog(this, "年龄不能为空！");
		}else if(null == pcardJt.getText() || "".equals(pcardJt.getText())){
			JOptionPane.showMessageDialog(this, "身份证号不能为空！");
		}else if(null == customerphoneJt.getText() || "".equals(customerphoneJt.getText())){
			JOptionPane.showMessageDialog(this, "电话不能为空！");
		}else if(null == addressJt.getText() || "".equals(addressJt.getText())){
			JOptionPane.showMessageDialog(this, "地址不能为空！");	
		}else if(null == brithDateJt.getText() || "".equals(brithDateJt.getText())){
			JOptionPane.showMessageDialog(this, "出生日期不能为空！");	
		}else {
			String sex = "男";
			if(womenRB.isSelected()){
				sex = "女";
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
				cs.edit(ce);
				JOptionPane.showMessageDialog(this, "修改成功！");
				dispose();
				cp.reflesh();
			} catch (ServerException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}	
	}

}
