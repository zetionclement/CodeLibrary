package server.dao;

import java.util.List;
import java.util.Map;

public interface IMgPageDao {
	/**
	 * 搜索功能
	 */
	public List<Object[]> show(Map<String, Object> condition, int page,
			int pageSize, String tableName, String requireName1,
			String requireName2);
	/**
	 * 获取总页数
	 */
	public Long getTotalPage(Map<String, Object> condition, String tableName,
			String requireName1, String requireName2);

}
