package server.service;

import java.util.Map;

import entity.PageData;
import entity.PageEntity;

public interface IMgPageService {
	/**
	 * ��������
	 */
	public PageData<PageEntity> show(Map<String, Object> condition, int page,
			int pageSize, String tableName, String requireName1,
			String requireName2);

}
