package server.service.impl;

import java.rmi.ServerException;

import entity.Customer;
import server.dao.ICustomerDao;
import server.dao.impl.CustomerDaoImpl;
import server.service.IMgCustomerService;

public class MgCustomerServiceImpl implements IMgCustomerService {
	private ICustomerDao customerDao = new CustomerDaoImpl();

	/**
	 * 根据ID删除信息
	 */
	@Override
	public void delete(int[] id) {
		customerDao.delete(id);

	}

	/**
	 * 查找客户编码是否重复，不重复就执行添加功能
	 */
	@Override
	public void add(Customer customerEntity) throws ServerException {
		if(null!=customerDao.findByNo(customerEntity.getCustomerNo())) {
			throw new ServerException("该编号已存在，请核对信息");
		}else {
			customerDao.add(customerEntity);
		}

	}

	@Override
	public Customer findByID(Integer id) {
		Customer ce = customerDao.findByID(id);
		return ce;
	}

	@Override
	public void edit(Customer customerEntity) throws ServerException {
		if(null == customerDao.findByID(customerEntity.getId())) {
			throw new ServerException("该员工不存在");
		}else {
			customerDao.edit(customerEntity);
		}

	}

}
