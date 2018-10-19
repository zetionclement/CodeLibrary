package manage.ui.medicinePane;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
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
import entity.Medicine;
import manage.ui.customerPane.CustomerPane;
import server.service.IMgMedicineService;
import server.service.impl.MgMedicineServiceImpl;
import util.DateChooserUtils;
import util.DateUtils;

public class MedicineAddDialog extends JDialog {
	private IMgMedicineService cs = new MgMedicineServiceImpl();
	private JTextField medicineNoJt;
	private JTextField medicineNameJt;
	private JTextField medicineTypeJt;
	private JTextField medicineFreeNameJt;
	private JTextField medicineGuideJt;
	private JTextField StockJt;
	private JTextField FreeJt;
	private JTextField JixingJt;
	private JTextField WayJt;
	private JTextField FunctionJt;
	private MedicinePane cp;
	
	/**
	 * Create the dialog.
	 */
	public MedicineAddDialog(MedicinePane cp) {
		this.cp = cp;
		setModal(true);//�Ѵ�������Ϊģ̬
		setResizable(false);//�û������϶���С
		setTitle("����ҩƷ");
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
		
		JLabel medicineNoJl = new JLabel("ҩƷ���:");
		medicineNoJl.setHorizontalAlignment(SwingConstants.RIGHT);
		medicineNoJl.setBounds(36, 29, 79, 15);
		panel.add(medicineNoJl);
		
		medicineNoJt = new JTextField();
		medicineNoJt.setColumns(4);
		medicineNoJt.setBounds(134, 26, 136, 21);
		panel.add(medicineNoJt);
		
		JLabel medicineNameJl = new JLabel("ҩƷ����:");
		medicineNameJl.setHorizontalAlignment(SwingConstants.RIGHT);
		medicineNameJl.setBounds(36, 70, 79, 15);
		panel.add(medicineNameJl);
		
		medicineNameJt = new JTextField();
		medicineNameJt.setColumns(3);
		medicineNameJt.setBounds(134, 67, 136, 21);
		panel.add(medicineNameJt);
		
		
		JLabel medicineTypeJl = new JLabel("ҩƷ����:");
		medicineTypeJl.setHorizontalAlignment(SwingConstants.RIGHT);
		medicineTypeJl.setBounds(36, 115, 79, 15);
		panel.add(medicineTypeJl);
		
		medicineTypeJt = new JTextField();
		medicineTypeJt.setColumns(2);
		medicineTypeJt.setBounds(134, 112, 136, 21);
		panel.add(medicineTypeJt);
		

		
		JLabel medicineFreeNameJl = new JLabel("ҩƷ������:");
		medicineFreeNameJl.setHorizontalAlignment(SwingConstants.RIGHT);
		medicineFreeNameJl.setBounds(36, 163, 79, 15);
		panel.add(medicineFreeNameJl);
		
		medicineFreeNameJt = new JTextField();
		medicineFreeNameJt.setColumns(10);
		medicineFreeNameJt.setBounds(134, 160, 136, 21);
		panel.add(medicineFreeNameJt);
		
		JLabel medicineguideJl = new JLabel("ʹ��ָ��:");
		medicineguideJl.setHorizontalAlignment(SwingConstants.RIGHT);
		medicineguideJl.setBounds(36, 209, 79, 15);
		panel.add(medicineguideJl);
		
		medicineGuideJt = new JTextField();
		medicineGuideJt.setColumns(18);
		medicineGuideJt.setBounds(134, 206, 136, 21);
		panel.add(medicineGuideJt);
		
		
		JLabel StockJl = new JLabel("����:");
		StockJl.setHorizontalAlignment(SwingConstants.RIGHT);
		StockJl.setBounds(36, 254, 79, 15);
		panel.add(StockJl);
		
		StockJt = new JTextField();
		StockJt.setColumns(11);
		StockJt.setBounds(134, 251, 136, 21);
		panel.add(StockJt);
		
		
		JLabel FreeJl = new JLabel("�۸�:");
		FreeJl.setHorizontalAlignment(SwingConstants.RIGHT);
		FreeJl.setBounds(36, 299, 79, 15);
		panel.add(FreeJl);
		
		FreeJt = new JTextField();
		FreeJt.setColumns(2);
		FreeJt.setBounds(134, 296, 136, 21);
		panel.add(FreeJt);
		
		JLabel JixingJl = new JLabel("����:");
		JixingJl.setHorizontalAlignment(SwingConstants.RIGHT);
		JixingJl.setBounds(36, 344, 79, 15);
		panel.add(JixingJl);
		
		JixingJt = new JTextField();
		JixingJt.setColumns(2);
		JixingJt.setBounds(134, 341, 136, 21);
		panel.add(JixingJt);
		
		JLabel WayJl = new JLabel("�÷�:");
		WayJl.setHorizontalAlignment(SwingConstants.RIGHT);
		WayJl.setBounds(36, 389, 79, 15);
		panel.add(WayJl);
		
		WayJt = new JTextField();
		WayJt.setColumns(2);
		WayJt.setBounds(134, 386, 136, 21);
		panel.add(WayJt);
		
		JLabel FunctionJl = new JLabel("��Ч:");
		FunctionJl.setHorizontalAlignment(SwingConstants.RIGHT);
		FunctionJl.setBounds(36, 431, 79, 15);
		panel.add(FunctionJl);
		
		FunctionJt = new JTextField();
		FunctionJt.setColumns(2);
		FunctionJt.setBounds(134, 428, 136, 21);
		panel.add(FunctionJt);
		
		
		
		

	}
	/**
	 * ���÷���
	 */
	public void reset(){
		medicineNoJt.setText("");
		medicineNameJt.setText("");
		medicineTypeJt.setText("");
		medicineGuideJt.setText("");
		StockJt.setText("");
		medicineFreeNameJt.setText("");
		FreeJt.setText("");
		JixingJt.setText("");
		WayJt.setText("");
		FunctionJt.setText("");
	}
	/**
	 * ����Ա��
	 */
	public void add(){
		Medicine ce = new Medicine();
		if(null == medicineNoJt.getText() || "".equals(medicineNoJt.getText())){
			JOptionPane.showMessageDialog(this, "ҩƷ��Ų���Ϊ�գ�");
		}else if(null == medicineNameJt.getText() || "".equals(medicineNameJt.getText())){
			JOptionPane.showMessageDialog(this, "ҩƷ������Ϊ�գ�");
		}else if(null == medicineTypeJt.getText() || "".equals(medicineTypeJt.getText())){
			JOptionPane.showMessageDialog(this, "���䲻��Ϊ�գ�");
		}else if(null == StockJt.getText() || "".equals(StockJt.getText())){
			JOptionPane.showMessageDialog(this, "��������Ϊ�գ�");
		}else if(null == medicineFreeNameJt.getText() || "".equals(medicineFreeNameJt.getText())){
			JOptionPane.showMessageDialog(this, "ҩƷ����������Ϊ�գ�");
		}else if(null == FreeJt.getText() || "".equals(FreeJt.getText())){
			JOptionPane.showMessageDialog(this, "�۸���Ϊ�գ�");	
		}else if(null == medicineGuideJt.getText() || "".equals(medicineGuideJt.getText())){
			JOptionPane.showMessageDialog(this, "ҩƷָ������Ϊ�գ�");	
		}else if(null ==JixingJt.getText() || "".equals(JixingJt.getText())){
			JOptionPane.showMessageDialog(this, "���Ͳ���Ϊ�գ�");	
		}else if(null == WayJt.getText() || "".equals(WayJt.getText())){
			JOptionPane.showMessageDialog(this, "�÷�����Ϊ�գ�");	
		}else if(null == FunctionJt.getText() || "".equals(FunctionJt.getText())){
			JOptionPane.showMessageDialog(this, "��Ч����Ϊ�գ�");	
		}else {
			int Stock = Integer.valueOf(StockJt.getText());
			BigDecimal Free =new BigDecimal(FreeJt.getText());
			
			ce.setMedicineNo(medicineNoJt.getText());
			ce.setMedicineName(medicineNameJt.getText());
			ce.setMedicineType(medicineTypeJt.getText());
			ce.setFreeName(medicineFreeNameJt.getText());
			ce.setMedicineGuige(medicineGuideJt.getText());
			ce.setStock(Stock);
			ce.setMedicineFree(Free);
			ce.setMedicineJixing(JixingJt.getText());
			ce.setMedicineWay(WayJt.getText());
			ce.setMedicineFunction(FunctionJt.getText());
			
			
			try {
				cs.add(ce);
				JOptionPane.showMessageDialog(this, "���ӳɹ���");
				dispose();
				cp.reflesh();
			} catch (ServerException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

}