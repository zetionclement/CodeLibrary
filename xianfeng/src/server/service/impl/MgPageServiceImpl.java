package server.service.impl;

import java.util.List;
import java.util.Map;

import entity.PageData;
import entity.PageEntity;
import server.dao.IMgPageDao;
import server.dao.impl.MgPageDaoImpl;
import server.service.IMgPageService;

public class MgPageServiceImpl implements IMgPageService {
	private IMgPageDao pageDao = new MgPageDaoImpl();

	@Override
	public PageData<PageEntity> show(Map<String, Object> condition, int page, int pageSize, String tableName,
			String requireName1, String requireName2) {
		List<Object[]> list = pageDao.show(condition, page, pageSize,tableName,requireName1,requireName2);
		Long totalPage = pageDao.getTotalPage(condition,tableName,requireName1,requireName2);
		return new PageData<>(page, pageSize, totalPage, list);
	                 }
	}


