package manange.ui.doctorPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import entity.Doctor;
import entity.PageData;
import entity.PageEntity;
import server.service.IMgDoctorService;
import server.service.impl.MgDoctorServiceImpl;
import util.PageUtils;

public class DoctorPane extends JPanel {
	private JTextField searchJt = new JTextField();
	private JTable table = new JTable();
	private PageData<PageEntity> pageData;
	private String tableName = "t_doctor";
	private String requireName1 = "D_No";
	private String requireName2 = "D_Name";
	private String[] columnName = new String[] { "ID",
			"医生编号", "姓名", "年龄",
			"性别", "联系电话",
			"身份证号", "科室名",
			"学位", "介绍",
			"入职时间" };
	private PageUtils pageUtils = new PageUtils(searchJt, table, pageData, columnName, tableName,requireName1,requireName2);
	
	private IMgDoctorService doctorService = new MgDoctorServiceImpl();
	private Doctor doctorEntity;
	
	/**
	 * Create the panel.
	 */
	public DoctorPane() {
		setLayout(new BorderLayout(0, 0));

		//-----------------------------------上部面板--------------
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.NORTH);

		//搜索按钮
		panel.add(searchJt);
		searchJt.setColumns(10);

		JButton searchBtn = new JButton("\u641C\u7D22");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageUtils.search();
			}
		});
		panel.add(searchBtn);

		//-----------------------------------底部面板--------------
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		//首页按钮
		JButton firstPageBtn = new JButton("\u9996\u9875");
		firstPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageUtils.firstPage();
			}
		});
		panel_1.add(firstPageBtn);
		//上一页按钮
		JButton prePageBtn = new JButton("\u4E0A\u4E00\u9875");
		prePageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageUtils.prePage();
			}
		});
		panel_1.add(prePageBtn);
		//下一页按钮
		JButton nextPageBtn = new JButton("\u4E0B\u4E00\u9875");
		nextPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageUtils.nextPage();
			}
		});
		panel_1.add(nextPageBtn);
		//末页按钮
		JButton lastPageBtn = new JButton("\u672B\u9875");
		lastPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageUtils.lastPage();
			}
		});
		panel_1.add(lastPageBtn);

		
		//-----------------------------------中间面板--------------
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_3, BorderLayout.NORTH);
		//添加按钮
		JButton addBtn = new JButton("\u6DFB\u52A0");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorAddDialog dialog = new DoctorAddDialog(DoctorPane.this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		panel_3.add(addBtn);
		//删除按钮
		JButton deleteBtn = new JButton("\u5220\u9664");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		panel_3.add(deleteBtn);
		//编辑按钮
		JButton repairBtn = new JButton("\u4FEE\u6539");
		repairBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		panel_3.add(repairBtn);
		//刷新按钮
		JButton refleshBtn = new JButton("\u5237\u65B0");
		refleshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reflesh();
			}
		});
		panel_3.add(refleshBtn);

		//数据库数据表
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);

		pageUtils.firstPage();
	}

	//-----------------------------------方法--------------
	/**
	 * 刷新
	 */
	public void reflesh() {
		int page = 1;
		pageUtils.view(page);
	}
	
	/**
	 * 删除方法
	 */
	public void delete() {
		int[] rows = table.getSelectedRows();// 获取点击行下标
		// 判断有没有选中行
		if (null != rows && rows.length > 0) {
			int[] id = new int[rows.length];
			for (int i = 0; i < id.length; i++) {
				Object val = table.getValueAt(rows[i], 0);
				id[i] = Integer.parseInt(val.toString());
			}
			doctorService.delete(id);
			JOptionPane.showMessageDialog(this, "删除成功！");
			reflesh();
		} else {
			JOptionPane.showMessageDialog(this, "请选择要删除的数据");
		}
	}
	
	/**
	 * 修改方法
	 */
	public void edit() {
		int[] line = table.getSelectedRows();// 获取点击行的下标
		if (null == line || line.length == 0) {
			JOptionPane.showMessageDialog(this, "请选择您要修改的数据！");
			return;
		}
		if (line.length > 1) {
			JOptionPane.showMessageDialog(this, "每次只能修改一行数据");
			return;
		}
		Object val = table.getValueAt(line[0], 0);
		Integer id = Integer.valueOf(val.toString());
		doctorEntity = doctorService.findByID(id);
		if (null == doctorEntity) {
			JOptionPane.showMessageDialog(this, "该记录已被删除！");
		} else {
			DoctorEditDialog ced = new DoctorEditDialog(doctorEntity, this);
			ced.setVisible(true);
			reflesh();
		}
	}

}
