package db.server.service.impl;

import java.util.List;

import db.server.service.ICustomerService;
import entity.Customer;
import server.dao.ICustomerDao;
import server.dao.impl.CustomerDaoImpl;


public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao customerdao = new CustomerDaoImpl();

	public Customer queryByCustomerNo(String CustomerNo) {
		return customerdao.queryByCustomerNo(CustomerNo);
	}

	public List queryAlldate(String CustomerNo) {
		return customerdao.queryAlldate(CustomerNo);
	}
	
}
