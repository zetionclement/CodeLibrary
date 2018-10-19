package server.service.impl;

import java.rmi.ServerException;
import entity.Login;
import entity.ManageLogin;
import server.dao.IMgLoginDao;
import server.dao.impl.MgLoginDaoImpl;
import server.service.IMgLoginService;

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
	@Override
	public void delete(int[] id) {
		mgLoginDao.delete(id);
		
	}
	@Override
	public void add(Login loginEntity) throws ServerException {
		if(null!=mgLoginDao.findByNo(loginEntity.getLoginNo())){
			throw new ServerException("�ñ���Ѵ��ڣ���˶���Ϣ��");
		}else{
			mgLoginDao.add(loginEntity);
		}
		
	}
	@Override
	public Login findByID(Integer id) {
		Login ce = mgLoginDao.findByID(id);
		return ce;
	}
	@Override
	public void edit(Login loginEntity) throws ServerException {
		if(null == mgLoginDao.findByID(loginEntity.getId())){
			throw new ServerException("��Ա�������ڣ�");
		}else{
			mgLoginDao.edit(loginEntity);
		}
	}
		
	

}
