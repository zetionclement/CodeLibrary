package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.PageData;
import entity.PageEntity;
import server.service.IMgPageService;
import server.service.impl.MgPageServiceImpl;

public class PageUtils {
	private JTextField searchJt;
	private JTable table;
	private PageData pageData;
	private String[] columnName;
	private String tableName;
	private String requireName1;
	private String requireName2;
	private IMgPageService pageService = new MgPageServiceImpl();
	
	
	
	public PageUtils(JTextField searchJt, JTable table,	PageData<PageEntity> pageData, String[] columnName,String tableName,String requireName1,String requireName2) {
		super();
		this.searchJt = searchJt;
		this.table = table;
		this.pageData = pageData;
		this.columnName = columnName;
		this.tableName = tableName;
		this.requireName1 = requireName1;
		this.requireName2 = requireName2;
	}
//---------------------分页搜索方法----------------------------
	/**
	 * 分页搜索方法
	 */
	public void view(int page) {
		String key = searchJt.getText();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("key1", key);
		pageData = pageService.show(condition, page, 10,tableName,requireName1,requireName2);
		Object[][] data = getData(pageData.getResultList());
		table.setModel(new DefaultTableModel(data, columnName));
	}
	
	public Object[][] getData(List<Object[]> list) {
		Object[][] data = new Object[list.size()][columnName.length];
		for (int i = 0; i < data.length; i++) {
			
			for (int j = 0; j < data[i].length; j++) {
				
				data[i][j] = list.get(i)[j];
			}
		}
		return data;
	}
	/**
	 * 重写分页搜索方法，可以自定义key的值
	 */
	public void view(int page,String key1) {
		String key = key1;
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("key1", key);
		pageData = pageService.show(condition, page, 10,tableName,requireName1,requireName2);
		Object[][] data = getData(pageData.getResultList());
		table.setModel(new DefaultTableModel(data, columnName));
	}
	
	
	/**
	 * 搜索方法
	 */
	public void search(){
		int page = 1;
		view(page);
	}
	
	/**
	 * 首页显示方法
	 */
	public void firstPage(){
		int page  = 1;
		view(page);
	}
	/**
	 * 末页
	 */
	public void lastPage(){
		int page = pageData.totalPages();
		view(page);
	}
	/**
	 * 上一页
	 */
	public void prePage(){
		int page = pageData.getPage();
		if(page <= 1){
			JOptionPane.showMessageDialog(null, "本页已经是第一页");
			page = 1;
		}else{
			page--;
		}
		view(page);
	}
	/**
	 * 下一页
	 */
	public void nextPage(){
		int page = pageData.getPage();
		if(page >= pageData.totalPages()){
			JOptionPane.showMessageDialog(null, "本页已经是最后一页");
			page = pageData.totalPages();
		}else{
			page++;
		}
		view(page);
	}
	/**
	 * 刷新方法
	 */
	public void reflesh(){
		int page = pageData.getPage();
		view(page);
	}

}
