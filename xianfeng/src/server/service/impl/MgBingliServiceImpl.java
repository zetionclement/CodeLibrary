package server.service.impl;

import java.rmi.ServerException;

import entity.Bingli;
import server.dao.IBingliDao;
import server.dao.impl.BingliDaoImpl;
import server.service.IMgBingliService;

public class MgBingliServiceImpl implements IMgBingliService {
	IBingliDao bingliDao = new BingliDaoImpl(); 

	@Override
	public void delete(int[] id) {
		bingliDao.delete(id);

	}

	@Override
	public void add(Bingli bingliEntity) throws ServerException {
		// TODO �Զ����ɵķ������

	}

	@Override
	public Bingli findByID(Integer id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void edit(Bingli bingliEntity) throws ServerException {
		// TODO �Զ����ɵķ������

	}

}
