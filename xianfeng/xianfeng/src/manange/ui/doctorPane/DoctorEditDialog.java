package manange.ui.doctorPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import entity.Doctor;
import entity.PageData;
import server.service.IMgDoctorService;
import server.service.impl.MgDoctorServiceImpl;
import util.DateChooserUtils;
import util.DateUtils;
import util.PageUtils;

public class DoctorEditDialog extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private IMgDoctorService cs = new MgDoctorServiceImpl();
	private DateChooserUtils dateChooser1 = DateChooserUtils.getInstance("yyyy-MM-dd");
	private JTextField doctorNoJt;
	private JTextField doctorNameJt;
	private JTextField doctorageJt;
	private JTextField pcardJt;
	private JTextField snameJt;
	private JTextField hireDateJt;
	private JTextField deducaJt;
	private JTextField doctorphoneJt;
	private JTextField dintroJt;
	private JRadioButton manRB;
	private JRadioButton womenRB;
	private Doctor ce;
	private DoctorPane cp;

	/**
	 * Create the dialog.
	 */
	public DoctorEditDialog(Doctor ce, DoctorPane cp) {
		this.ce = ce;
		this.cp = cp;
		setModal(true);//把窗口设置为模态
		setResizable(false);//用户不能拖动大小
		setTitle("修改医生");
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
		
		JLabel doctorNoJl = new JLabel("医生姓名:");
		doctorNoJl.setHorizontalAlignment(SwingConstants.RIGHT);
		doctorNoJl.setBounds(36, 29, 79, 15);
		contentPanel.add(doctorNoJl);
		
		doctorNoJt = new JTextField();
		doctorNoJt.setBounds(134, 26, 136, 21);
		contentPanel.add(doctorNoJt);
		doctorNoJt.setColumns(10);
		
		JLabel doctorNameJl = new JLabel("医生编号:");
		doctorNameJl.setHorizontalAlignment(SwingConstants.RIGHT);
		doctorNameJl.setBounds(36, 70, 79, 15);
		contentPanel.add(doctorNameJl);
		
		doctorNameJt = new JTextField();
		doctorNameJt.setColumns(10);
		doctorNameJt.setBounds(134, 67, 136, 21);
		contentPanel.add(doctorNameJt);
		
		JLabel sexJl = new JLabel("性别:");
		sexJl.setHorizontalAlignment(SwingConstants.RIGHT);
		sexJl.setBounds(36, 115, 79, 15);
		contentPanel.add(sexJl);
		
		JLabel doctorageJl = new JLabel("年龄:");
		doctorageJl.setHorizontalAlignment(SwingConstants.RIGHT);
		doctorageJl.setBounds(36, 163, 79, 15);
		contentPanel.add(doctorageJl);
		
		doctorageJt = new JTextField();
		doctorageJt.setColumns(10);
		doctorageJt.setBounds(134, 160, 136, 21);
		contentPanel.add(doctorageJt);
		
		JLabel hireDateJl = new JLabel("入职日期:");
		hireDateJl.setHorizontalAlignment(SwingConstants.RIGHT);
		hireDateJl.setBounds(36, 209, 79, 15);
		contentPanel.add(hireDateJl);
		
		hireDateJt = new JTextField();
		hireDateJt.setEditable(false);
		dateChooser1.register(hireDateJt);
		hireDateJt.setBounds(134, 206, 136, 21);
		contentPanel.add(hireDateJt);
		hireDateJt.setColumns(10);
		
		JLabel pcardJl = new JLabel("身份证号:");
		pcardJl.setHorizontalAlignment(SwingConstants.RIGHT);
		pcardJl.setBounds(36, 254, 79, 15);
		contentPanel.add(pcardJl);
		
		pcardJt = new JTextField();
		pcardJt.setColumns(10);
		pcardJt.setBounds(134, 251, 136, 21);
		contentPanel.add(pcardJt);
				
		JLabel doctorphoneJl = new JLabel("电话:");
		doctorphoneJl.setHorizontalAlignment(SwingConstants.RIGHT);
		doctorphoneJl.setBounds(36, 299, 79, 15);
		contentPanel.add(doctorphoneJl);
		
		doctorphoneJt = new JTextField();
		doctorphoneJt.setColumns(11);
		doctorphoneJt.setBounds(134, 296, 136, 21);
		contentPanel.add(doctorphoneJt);
		
		JLabel snameJl = new JLabel("科室:");
		snameJl.setHorizontalAlignment(SwingConstants.RIGHT);
		snameJl.setBounds(36, 344, 79, 15);
		contentPanel.add(snameJl);
		
		snameJt = new JTextField();
		snameJt.setColumns(10);
		snameJt.setBounds(134, 340, 136, 21);
		contentPanel.add(snameJt);
		
		JLabel deducaJl = new JLabel("学位:");
		deducaJl.setHorizontalAlignment(SwingConstants.RIGHT);
		deducaJl.setBounds(36, 389, 79, 15);
		contentPanel.add(deducaJl);
		
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
		
		deducaJt = new JTextField();
		deducaJt.setColumns(2);
		deducaJt.setBounds(134, 386, 136, 21);
		contentPanel.add(deducaJt);
		
		JLabel dintroJl = new JLabel("介绍:");
		dintroJl.setHorizontalAlignment(SwingConstants.RIGHT);
		dintroJl.setBounds(36, 434, 79, 15);
		contentPanel.add(dintroJl);
		
		dintroJt = new JTextField();
		dintroJt.setColumns(2);
		dintroJt.setBounds(134, 431, 136, 21);
		contentPanel.add(dintroJt);
		
		showInfo();
	}
	/**
	 * 重置
	 */
	public void reset(){
		doctorNoJt.setText("");
		doctorNameJt.setText("");
		manRB.setSelected(true);
		doctorageJt.setText("");
		doctorphoneJt.setText("");
		hireDateJt.setText("");
		pcardJt.setText("");
		deducaJt.setText("");
		snameJt.setText("");
		dintroJt.setText("");
	}
	/**
	 * 显示方法
	 */
	public void showInfo(){
		
		String sex = ce.getDoctorSex();
		String hireDate = DateUtils.getDateStr(ce.getDootorHiredate());
		
		String age = String.valueOf(ce.getDoctorAge());
		
		doctorNoJt.setText(ce.getDoctorNo());
		doctorNameJt.setText(ce.getDoctorName());
		doctorageJt.setText(age);
		pcardJt.setText(ce.getDoctorPcard());
		doctorphoneJt.setText(ce.getDoctorTel());
		hireDateJt.setText(hireDate);
		snameJt.setText(ce.getSectionName());
		dintroJt.setText(ce.getDoctorIntroduce());
		deducaJt.setText(ce.getDoctorEduction());

		
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
		}else{
			Integer doctorage = Integer.valueOf(doctorageJt.getText());
			
			String sex = "男";
			if(womenRB.isSelected()){
				sex = "女";
			}
			Date hireDate = DateUtils.getDate(hireDateJt.getText());
			
			
			ce.setDoctorNo(doctorNoJt.getText());
			ce.setDoctorName(doctorNameJt.getText());
			ce.setDoctorSex(sex);
			ce.setDoctorAge(doctorage);
			ce.setDootorHiredate(hireDate);
			ce.setDoctorPcard(pcardJt.getText());
			ce.setDoctorTel(doctorphoneJt.getText());
			ce.setSectionName(snameJt.getText());
			ce.setDoctorEduction(deducaJt.getText());
			ce.setDoctorIntroduce(dintroJt.getText());

			
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
