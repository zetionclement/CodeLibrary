package manage.ui.medicinePane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.ServerException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import entity.Medicine;
import server.service.IMgMedicineService;
import server.service.impl.MgMedicineServiceImpl;
import util.DateUtils;

public class MedicineEditDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4234634649048895976L;
	private final JPanel contentPanel = new JPanel();
	private Medicine ce;
	private MedicinePane cp;
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
	
	public MedicineEditDialog(Medicine ce, MedicinePane cp) {
		this.ce = ce;
		this.cp = cp;
		setModal(true);//把窗口设置为模态
		setResizable(false);//用户不能拖动大小
		setTitle("修改药品");
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
		
		JLabel medicineNoJl = new JLabel("药品编号:");
		medicineNoJl.setHorizontalAlignment(SwingConstants.RIGHT);
		medicineNoJl.setBounds(36, 29, 79, 15);
		contentPanel.add(medicineNoJl);
		
		medicineNoJt = new JTextField();
		medicineNoJt.setColumns(4);
		medicineNoJt.setBounds(134, 26, 136, 21);
		contentPanel.add(medicineNoJt);
		
		JLabel medicineNameJl = new JLabel("药品名:");
		medicineNameJl.setHorizontalAlignment(SwingConstants.RIGHT);
		medicineNameJl.setBounds(36, 70, 79, 15);
		contentPanel.add(medicineNameJl);
		
		medicineNameJt = new JTextField();
		medicineNameJt.setColumns(3);
		medicineNameJt.setBounds(134, 67, 136, 21);
		contentPanel.add(medicineNameJt);
		
		
		JLabel medicineTypeJl = new JLabel("药品类型:");
		medicineTypeJl.setHorizontalAlignment(SwingConstants.RIGHT);
		medicineTypeJl.setBounds(36, 115, 79, 15);
		contentPanel.add(medicineTypeJl);
		
		medicineTypeJt = new JTextField();
		medicineTypeJt.setColumns(2);
		medicineTypeJt.setBounds(134, 112, 136, 21);
		contentPanel.add(medicineTypeJt);
		

		
		JLabel medicineFreeNameJl = new JLabel("药品费用名:");
		medicineFreeNameJl.setHorizontalAlignment(SwingConstants.RIGHT);
		medicineFreeNameJl.setBounds(36, 163, 79, 15);
		contentPanel.add(medicineFreeNameJl);
		
		medicineFreeNameJt = new JTextField();
		medicineFreeNameJt.setColumns(10);
		medicineFreeNameJt.setBounds(134, 160, 136, 21);
		contentPanel.add(medicineFreeNameJt);
		
		JLabel medicineguideJl = new JLabel("使用指引:");
		medicineguideJl.setHorizontalAlignment(SwingConstants.RIGHT);
		medicineguideJl.setBounds(36, 209, 79, 15);
		contentPanel.add(medicineguideJl);
		
		medicineGuideJt = new JTextField();
		medicineGuideJt.setColumns(18);
		medicineGuideJt.setBounds(134, 206, 136, 21);
		contentPanel.add(medicineGuideJt);
		
		
		JLabel StockJl = new JLabel("存量:");
		StockJl.setHorizontalAlignment(SwingConstants.RIGHT);
		StockJl.setBounds(36, 254, 79, 15);
		contentPanel.add(StockJl);
		
		StockJt = new JTextField();
		StockJt.setColumns(11);
		StockJt.setBounds(134, 251, 136, 21);
		contentPanel.add(StockJt);
		
		
		JLabel FreeJl = new JLabel("价格:");
		FreeJl.setHorizontalAlignment(SwingConstants.RIGHT);
		FreeJl.setBounds(36, 299, 79, 15);
		contentPanel.add(FreeJl);
		
		FreeJt = new JTextField();
		FreeJt.setColumns(2);
		FreeJt.setBounds(134, 296, 136, 21);
		contentPanel.add(FreeJt);
		
		JLabel JixingJl = new JLabel("剂型:");
		JixingJl.setHorizontalAlignment(SwingConstants.RIGHT);
		JixingJl.setBounds(36, 344, 79, 15);
		contentPanel.add(JixingJl);
		
		JixingJt = new JTextField();
		JixingJt.setColumns(2);
		JixingJt.setBounds(134, 341, 136, 21);
		contentPanel.add(JixingJt);
		
		JLabel WayJl = new JLabel("用法:");
		WayJl.setHorizontalAlignment(SwingConstants.RIGHT);
		WayJl.setBounds(36, 389, 79, 15);
		contentPanel.add(WayJl);
		
		WayJt = new JTextField();
		WayJt.setColumns(2);
		WayJt.setBounds(134, 386, 136, 21);
		contentPanel.add(WayJt);
		
		JLabel FunctionJl = new JLabel("功效:");
		FunctionJl.setHorizontalAlignment(SwingConstants.RIGHT);
		FunctionJl.setBounds(36, 431, 79, 15);
		contentPanel.add(FunctionJl);
		
		FunctionJt = new JTextField();
		FunctionJt.setColumns(2);
		FunctionJt.setBounds(134, 428, 136, 21);
		contentPanel.add(FunctionJt);
		
	
		showInfo();
	}
	/**
	 * 重置方法
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
	 * 显示方法
	 */
	public void showInfo(){
		
		String stock = String.valueOf(ce.getStock());
		medicineNoJt.setText(ce.getMedicineNo());
		medicineNameJt.setText(ce.getMedicineName());
		medicineTypeJt.setText(ce.getMedicineType());
		medicineFreeNameJt.setText(ce.getFreeName());
		medicineGuideJt.setText(ce.getMedicineGuige());
		StockJt.setText(stock);
		FreeJt.setText(ce.getMedicineFree().toString());
		JixingJt.setText(ce.getMedicineJixing());
		WayJt.setText(ce.getMedicineWay());
		FunctionJt.setText(ce.getMedicineFunction());


		

	}
	/**
	 * 修改方法
	 */
	public void edit(){
		Medicine ce = new Medicine();
		if(null == medicineNoJt.getText() || "".equals(medicineNoJt.getText())){
			JOptionPane.showMessageDialog(this, "药品编号不能为空！");
		}else if(null == medicineNameJt.getText() || "".equals(medicineNameJt.getText())){
			JOptionPane.showMessageDialog(this, "药品名不能为空！");
		}else if(null == medicineTypeJt.getText() || "".equals(medicineTypeJt.getText())){
			JOptionPane.showMessageDialog(this, "年龄不能为空！");
		}else if(null == StockJt.getText() || "".equals(StockJt.getText())){
			JOptionPane.showMessageDialog(this, "存量不能为空！");
		}else if(null == medicineFreeNameJt.getText() || "".equals(medicineFreeNameJt.getText())){
			JOptionPane.showMessageDialog(this, "药品费用名不能为空！");
		}else if(null == FreeJt.getText() || "".equals(FreeJt.getText())){
			JOptionPane.showMessageDialog(this, "价格不能为空！");	
		}else if(null == medicineGuideJt.getText() || "".equals(medicineGuideJt.getText())){
			JOptionPane.showMessageDialog(this, "药品指引不能为空！");	
		}else if(null ==JixingJt.getText() || "".equals(JixingJt.getText())){
			JOptionPane.showMessageDialog(this, "剂型不能为空！");	
		}else if(null == WayJt.getText() || "".equals(WayJt.getText())){
			JOptionPane.showMessageDialog(this, "用法不能为空！");	
		}else if(null == FunctionJt.getText() || "".equals(FunctionJt.getText())){
			JOptionPane.showMessageDialog(this, "功效不能为空！");	
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
