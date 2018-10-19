package db.server.service;

import java.util.List;

import entity.Customer;

public interface ICustomerService {
	/**
	 * 根据就诊卡号找到客户信息
	 */
	public Customer queryByCustomerNo(String CustomerNo) ;
	/**
	 * 根据就诊卡号找到所以曾经就诊日期
	 */
	public  List queryAlldate(String CustomerNo);
}
