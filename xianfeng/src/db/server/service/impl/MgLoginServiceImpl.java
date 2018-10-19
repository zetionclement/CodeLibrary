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
     * 登陆方法
     */
	@Override
	public boolean login(ManageLogin managelogin) throws ServerException {
		if(null == mgLoginDao.findByName(managelogin.getLNo())) {
			throw new ServerException("用户名不正确");
		}else {
			//比较密码是否正确
			if(managelogin.getLPw().equals(mgLoginDao.findByName(managelogin.getLNo()).getLPw()))
			{
				return true;
			}
		}
		return false;
	
	}

}
