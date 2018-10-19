package db.server.service.impl;

import java.rmi.ServerException;

import javax.print.attribute.standard.PrinterLocation;

import entity.ManageLogin;
import server.dao.IMgLoginDao;
import server.dao.impl.MgLoginDaoImpl;
import db.server.service.IMgLoginService;

public class MgLoginServiceImpl implements IMgLoginService {
	private IMgLoginDao mgLoginDao = new MgLoginDaoImpl();
    /**
     * ��½����
     */
	@Override
	public boolean login(ManageLogin managelogin) throws ServerException {
		if(null == mgLoginDao.findByName(managelogin.getLNo())) {
			throw new ServerException("�û�������ȷ");
		}else {
			//�Ƚ������Ƿ���ȷ
			if(managelogin.getLPw().equals(mgLoginDao.findByName(managelogin.getLNo()).getLPw()))
			{
				return true;
			}
		}
		return false;
	
	}

}
