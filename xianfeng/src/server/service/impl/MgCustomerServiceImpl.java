package server.service.impl;

import java.rmi.ServerException;

import entity.Customer;
import server.dao.ICustomerDao;
import server.dao.impl.CustomerDaoImpl;
import server.service.IMgCustomerService;

public class MgCustomerServiceImpl implements IMgCustomerService {
	private ICustomerDao customerDao = new CustomerDaoImpl();

	/**
	 * ����IDɾ����Ϣ
	 */
	@Override
	public void delete(int[] id) {
		customerDao.delete(id);

	}

	/**
	 * ���ҿͻ������Ƿ��ظ������ظ���ִ����ӹ���
	 */
	@Override
	public void add(Customer customerEntity) throws ServerException {
		if(null!=customerDao.findByNo(customerEntity.getCustomerNo())) {
			throw new ServerException("�ñ���Ѵ��ڣ���˶���Ϣ");
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
			throw new ServerException("��Ա��������");
		}else {
			customerDao.edit(customerEntity);
		}

	}

}
