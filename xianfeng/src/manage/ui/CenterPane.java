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
	 * 初始化组件
	 */
	public void initComponents() {
		rightPane = new ManageRightPane();
		leftPane = new ManageLeftPane(rightPane);
	}
	/**
	 * 组件布局
	 */
	public void layoutComponents() {
		setLeftComponent(leftPane);
		setRightComponent(rightPane);
		setDividerLocation(150);
	}

}
