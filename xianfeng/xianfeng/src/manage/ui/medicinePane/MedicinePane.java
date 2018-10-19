package manage.ui.medicinePane;

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
import entity.Medicine;
import entity.PageData;
import server.service.IMgMedicineService;
import server.service.impl.MgMedicineServiceImpl;
import util.PageUtils;

public class MedicinePane extends JPanel {
	private JTextField searchJt = new JTextField();
	private JTable table = new JTable();
	private PageData pageData;
	private String tableName = "t_medicines";
	private String requireName1 = "M_No";
	private String requireName2 = "M_Name";
	private String[] columnName = new String[] { "ID",
			"ҩƷ���", "ҩƷ��", "ҩƷ����",
			"ҩƷ������", "ʹ��ָ��",
			"����", "�۸�","����",
			"�÷�", "��Ч" };
	private PageUtils pageUtils = new PageUtils(searchJt, table, pageData, columnName, tableName,requireName1,requireName2);
	
	private IMgMedicineService medicineService = new MgMedicineServiceImpl();
	private Medicine MedicineEntity;
	
	/**
	 * Create the panel.
	 */
	public MedicinePane() {
		setLayout(new BorderLayout(0, 0));

		//-----------------------------------�ϲ����--------------
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.NORTH);

		//������ť
		panel.add(searchJt);
		searchJt.setColumns(10);

		JButton searchBtn = new JButton("\u641C\u7D22");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageUtils.search();
			}
		});
		panel.add(searchBtn);

		//-----------------------------------�ײ����--------------
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		//��ҳ��ť
		JButton firstPageBtn = new JButton("\u9996\u9875");
		firstPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageUtils.firstPage();
			}
		});
		panel_1.add(firstPageBtn);
		//��һҳ��ť
		JButton prePageBtn = new JButton("\u4E0A\u4E00\u9875");
		prePageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageUtils.prePage();
			}
		});
		panel_1.add(prePageBtn);
		//��һҳ��ť
		JButton nextPageBtn = new JButton("\u4E0B\u4E00\u9875");
		nextPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageUtils.nextPage();
			}
		});
		panel_1.add(nextPageBtn);
		//ĩҳ��ť
		JButton lastPageBtn = new JButton("\u672B\u9875");
		lastPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageUtils.lastPage();
			}
		});
		panel_1.add(lastPageBtn);

		
		//-----------------------------------�м����--------------
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_3, BorderLayout.NORTH);
		//��Ӱ�ť
		JButton addBtn = new JButton("\u6DFB\u52A0");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicineAddDialog dialog = new MedicineAddDialog(MedicinePane.this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		panel_3.add(addBtn);
		//ɾ����ť
		JButton deleteBtn = new JButton("\u5220\u9664");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		panel_3.add(deleteBtn);
		//�༭��ť
		JButton repairBtn = new JButton("\u4FEE\u6539");
		repairBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		panel_3.add(repairBtn);
		//ˢ�°�ť
		JButton refleshBtn = new JButton("\u5237\u65B0");
		refleshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reflesh();
			}
		});
		panel_3.add(refleshBtn);

		//���ݿ����ݱ�
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);

		pageUtils.firstPage();
	}

	//-----------------------------------����--------------
	/**
	 * ˢ��
	 */
	public void reflesh() {
		int page = 1;
		pageUtils.view(page);
	}
	
	/**
	 * ɾ������
	 */
	public void delete() {
		int[] rows = table.getSelectedRows();// ��ȡ������±�
		// �ж���û��ѡ����
		if (null != rows && rows.length > 0) {
			int[] id = new int[rows.length];
			for (int i = 0; i < id.length; i++) {
				Object val = table.getValueAt(rows[i], 0);
				id[i] = Integer.parseInt(val.toString());
			}
			medicineService.delete(id);
			JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
			reflesh();
		} else {
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ��������");
		}
	}
	
	/**
	 * �޸ķ���
	 */
	public void edit() {
		int[] line = table.getSelectedRows();// ��ȡ����е��±�
		if (null == line || line.length == 0) {
			JOptionPane.showMessageDialog(this, "��ѡ����Ҫ�޸ĵ����ݣ�");
			return;
		}
		if (line.length > 1) {
			JOptionPane.showMessageDialog(this, "ÿ��ֻ���޸�һ������");
			return;
		}
		Object val = table.getValueAt(line[0], 0);
		Integer id = Integer.valueOf(val.toString());
		MedicineEntity = medicineService.findByID(id);
		if (null == MedicineEntity) {
			JOptionPane.showMessageDialog(this, "�ü�¼�ѱ�ɾ����");
		} else {
			MedicineEditDialog ced = new MedicineEditDialog(MedicineEntity, this);
			ced.setVisible(true);
			reflesh();
		}
	}

}
