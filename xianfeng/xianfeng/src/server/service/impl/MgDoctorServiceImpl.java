package server.service.impl;

import java.rmi.ServerException;

import entity.Doctor;
import server.dao.IDoctorDao;
import server.dao.impl.DoctorDaoImpl;
import server.service.IMgDoctorService;

public class MgDoctorServiceImpl implements IMgDoctorService {
	private IDoctorDao doctorDao = new DoctorDaoImpl();
	
	/**
	 * ����IDɾ����Ϣ
	 */
	@Override
	public void delete(int[] id) {
		doctorDao.delete(id);
	}

	/**
	 * ����ҽ�������Ƿ��ظ������ظ���ִ����ӹ���
	 */
	@Override
	public void add(Doctor doctorEntity) throws ServerException {
		if(null!=doctorDao.findByNo(doctorEntity.getDoctorNo())) {
			throw new ServerException("�ñ���Ѵ��ڣ���˶���Ϣ");
		}else {
			doctorDao.add(doctorEntity);
		}

	}

	/**
	 * ͨ��id������Ϣ
	 */
	@Override
	public Doctor findByID(Integer id) {
		Doctor ce = doctorDao.findByID(id);
		return ce;
	}

	/**
	 * �޸���Ϣ
	 */
	@Override
	public void edit(Doctor doctorEntity) throws ServerException {
		if(null == doctorDao.findByID(doctorEntity.getId())) {
			throw new ServerException("��Ա��������");
		}else {
			doctorDao.edit(doctorEntity);
		}
	}

}
