package manange.ui.doctorPane;

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

import entity.Doctor;
import server.service.IMgDoctorService;
import server.service.impl.MgDoctorServiceImpl;
import util.DateChooserUtils;
import util.DateUtils;

public class DoctorAddDialog extends JDialog {
	private IMgDoctorService cs = new MgDoctorServiceImpl();
	private DateChooserUtils dateChooser1 = DateChooserUtils.getInstance("yyyy-MM-dd");
	private JTextField doctorNoJt;
	private JTextField doctorNameJt;
	private JTextField doctorageJt;
	private JTextField doctorphoneJt;
	private JTextField hireDateJt;
	private JTextField pcardJt;
	private JTextField snameJt;
	private JTextField deducaJt;
	private JTextField dintroJt;
	private JRadioButton manRB;
	private JRadioButton womenRB;
	private DoctorPane cp;
	
	/**
	 * Create the dialog.
	 */
	public DoctorAddDialog(DoctorPane cp) {
		this.cp = cp;
		setModal(true);//把窗口设置为模态
		setResizable(false);//用户不能拖动大小
		setTitle("添加医生");
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
		
		JLabel doctorNoJl = new JLabel("医生编号:");
		doctorNoJl.setHorizontalAlignment(SwingConstants.RIGHT);
		doctorNoJl.setBounds(36, 29, 79, 15);
		panel.add(doctorNoJl);
		
		doctorNoJt = new JTextField();
		doctorNoJt.setColumns(4);
		doctorNoJt.setBounds(134, 26, 136, 21);
		panel.add(doctorNoJt);
		
		JLabel doctorNameJl = new JLabel("医生姓名:");
		doctorNameJl.setHorizontalAlignment(SwingConstants.RIGHT);
		doctorNameJl.setBounds(36, 70, 79, 15);
		panel.add(doctorNameJl);
		
		doctorNameJt = new JTextField();
		doctorNameJt.setColumns(3);
		doctorNameJt.setBounds(134, 67, 136, 21);
		panel.add(doctorNameJt);
		
		JLabel sexJl = new JLabel("性别:");
		sexJl.setHorizontalAlignment(SwingConstants.RIGHT);
		sexJl.setBounds(36, 115, 79, 15);
		panel.add(sexJl);
		
		JLabel doctorageJl = new JLabel("年龄:");
		doctorageJl.setHorizontalAlignment(SwingConstants.RIGHT);
		doctorageJl.setBounds(36, 163, 79, 15);
		panel.add(doctorageJl);
		
		doctorageJt = new JTextField();
		doctorageJt.setColumns(2);
		doctorageJt.setBounds(134, 160, 136, 21);
		panel.add(doctorageJt);
		

		
		JLabel hireDateJl = new JLabel("入职日期:");
		hireDateJl.setHorizontalAlignment(SwingConstants.RIGHT);
		hireDateJl.setBounds(36, 209, 79, 15);
		panel.add(hireDateJl);
		
		hireDateJt = new JTextField();
		hireDateJt.setEditable(false);
		dateChooser1.register(hireDateJt);
		hireDateJt.setColumns(10);
		hireDateJt.setBounds(134, 206, 136, 21);
		panel.add(hireDateJt);
		
		JLabel pcardJl = new JLabel("身份证号:");
		pcardJl.setHorizontalAlignment(SwingConstants.RIGHT);
		pcardJl.setBounds(36, 254, 79, 15);
		panel.add(pcardJl);
		
		pcardJt = new JTextField();
		pcardJt.setColumns(18);
		pcardJt.setBounds(134, 251, 136, 21);
		panel.add(pcardJt);
		
		
		JLabel doctorphoneJl = new JLabel("电话:");
		doctorphoneJl.setHorizontalAlignment(SwingConstants.RIGHT);
		doctorphoneJl.setBounds(36, 299, 79, 15);
		panel.add(doctorphoneJl);
		
		doctorphoneJt = new JTextField();
		doctorphoneJt.setColumns(11);
		doctorphoneJt.setBounds(134, 296, 136, 21);
		panel.add(doctorphoneJt);
		
		JLabel snameJl = new JLabel("科室:");
		snameJl.setHorizontalAlignment(SwingConstants.RIGHT);
		snameJl.setBounds(36, 344, 79, 15);
		panel.add(snameJl);
		
		snameJt = new JTextField();
		snameJt.setColumns(2);
		snameJt.setBounds(134, 341, 136, 21);
		panel.add(snameJt);
		
		JLabel deducaJl = new JLabel("学位:");
		deducaJl.setHorizontalAlignment(SwingConstants.RIGHT);
		deducaJl.setBounds(36, 389, 79, 15);
		panel.add(deducaJl);
		
		deducaJt = new JTextField();
		deducaJt.setColumns(2);
		deducaJt.setBounds(134, 386, 136, 21);
		panel.add(deducaJt);
		
		JLabel dintroJl = new JLabel("介绍:");
		dintroJl.setHorizontalAlignment(SwingConstants.RIGHT);
		dintroJl.setBounds(36, 434, 79, 15);
		panel.add(dintroJl);
		
		dintroJt = new JTextField();
		dintroJt.setColumns(2);
		dintroJt.setBounds(134, 431, 136, 21);
		panel.add(dintroJt);
		
		manRB = new JRadioButton("\u7537");
		manRB.setBounds(134, 111, 54, 23);
		manRB.setSelected(true);
		panel.add(manRB);
		
		womenRB = new JRadioButton("\u5973");
		womenRB.setBounds(197, 111, 54, 23);
		panel.add(womenRB);
		ButtonGroup bg = new ButtonGroup(); // 创建按钮组对象
		bg.add(manRB);
		bg.add(womenRB);
		
		
		

	}
	/**
	 * 重置方法
	 */
	public void reset(){
		doctorNoJt.setText("");
		doctorNameJt.setText("");
		manRB.setSelected(true);
		doctorageJt.setText("");
		hireDateJt.setText("");
		pcardJt.setText("");
		doctorphoneJt.setText("");
		snameJt.setText("");
		deducaJt.setText("");
		dintroJt.setText("");
	}
	/**
	 * 添加员工
	 */
	public void add(){
		Doctor ce = new Doctor();
		if(null == doctorNoJt.getText() || "".equals(doctorNoJt.getText())){
			JOptionPane.showMessageDialog(this, "医生编号不能为空！");
		}else if(null == doctorNameJt.getText() || "".equals(doctorNameJt.getText())){
			JOptionPane.showMessageDialog(this, "医生名字不能为空！");
		}else if(null == doctorageJt.getText() || "".equals(doctorageJt.getText())){
			JOptionPane.showMessageDialog(this, "年龄不能为空！");
		}else if(null == hireDateJt.getText() || "".equals(hireDateJt.getText())){
			JOptionPane.showMessageDialog(this, "入职日期不能为空！");
		}else if(null == pcardJt.getText() || "".equals(pcardJt.getText())){
			JOptionPane.showMessageDialog(this, "身份证号不能为空！");
		}else if(null == doctorphoneJt.getText() || "".equals(doctorphoneJt.getText())){
			JOptionPane.showMessageDialog(this, "电话不能为空！");
		}else if(null == snameJt.getText() || "".equals(snameJt.getText())){
			JOptionPane.showMessageDialog(this, "科室不能为空！");	
		}else if(null == deducaJt.getText() || "".equals(deducaJt.getText())){
			JOptionPane.showMessageDialog(this, "学位不能为空！");	
		}else {
			String sex = "男";
			if(womenRB.isSelected()){
				sex = "女";
			}
			Date hireDate = DateUtils.getDate(hireDateJt.getText());
			int age = Integer.valueOf(doctorageJt.getText());
			
			ce.setDoctorNo(doctorNoJt.getText());
			ce.setDoctorName(doctorNameJt.getText());
			ce.setDoctorAge(age);
			ce.setDoctorSex(sex);
			ce.setDoctorTel(doctorphoneJt.getText());
			ce.setDootorHiredate(hireDate);
			ce.setDoctorPcard(pcardJt.getText());
			ce.setSectionName(snameJt.getText());
			ce.setDoctorEduction(deducaJt.getText());
			ce.setDoctorIntroduce(dintroJt.getText());

			try {
				cs.add(ce);
				JOptionPane.showMessageDialog(this, "添加成功！");
				dispose();
				cp.reflesh();
			} catch (ServerException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

}
