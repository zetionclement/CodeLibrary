package db.server.service.impl;

import server.dao.IBingliDao;
import server.dao.impl.BingliDaoImpl;
import db.server.service.IBingliService;

public class BingliServiceImpl implements IBingliService {
    private IBingliDao binglidao = new BingliDaoImpl();
	@Override
	public String findResult(String CustomerNo, String Time) {
		return binglidao.findResult(CustomerNo, Time);
	}

	@Override
	public String findPlan(String CustomerNo, String Time) {
		return binglidao.findPlan(CustomerNo, Time);
	}

}
