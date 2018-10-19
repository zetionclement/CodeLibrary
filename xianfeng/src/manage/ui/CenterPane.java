package manage.ui;

import javax.swing.JSplitPane;

public class CenterPane extends JSplitPane {
	private ManageLeftPane leftPane;
	private ManageRightPane rightPane;

	public CenterPane() {
		initComponents();
		layoutComponents();
	}
	/**
	 * ��ʼ�����
	 */
	public void initComponents() {
		rightPane = new ManageRightPane();
		leftPane = new ManageLeftPane(rightPane);
	}
	/**
	 * �������
	 */
	public void layoutComponents() {
		setLeftComponent(leftPane);
		setRightComponent(rightPane);
		setDividerLocation(150);
	}

}
