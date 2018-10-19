package server.service.impl;

import java.rmi.ServerException;

import entity.Doctor;
import server.dao.IDoctorDao;
import server.dao.impl.DoctorDaoImpl;
import server.service.IMgDoctorService;

public class MgDoctorServiceImpl implements IMgDoctorService {
	private IDoctorDao doctorDao = new DoctorDaoImpl();
	
	/**
	 * 根据ID删除信息
	 */
	@Override
	public void delete(int[] id) {
		doctorDao.delete(id);
	}

	/**
	 * 查找医生编码是否重复，不重复就执行添加功能
	 */
	@Override
	public void add(Doctor doctorEntity) throws ServerException {
		if(null!=doctorDao.findByNo(doctorEntity.getDoctorNo())) {
			throw new ServerException("该编号已存在，请核对信息");
		}else {
			doctorDao.add(doctorEntity);
		}

	}

	/**
	 * 通过id查找信息
	 */
	@Override
	public Doctor findByID(Integer id) {
		Doctor ce = doctorDao.findByID(id);
		return ce;
	}

	/**
	 * 修改信息
	 */
	@Override
	public void edit(Doctor doctorEntity) throws ServerException {
		if(null == doctorDao.findByID(doctorEntity.getId())) {
			throw new ServerException("该员工不存在");
		}else {
			doctorDao.edit(doctorEntity);
		}
	}

}
