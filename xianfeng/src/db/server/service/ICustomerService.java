package db.server.service;

import java.util.List;

import entity.Customer;

public interface ICustomerService {
	/**
	 * ���ݾ��￨���ҵ��ͻ���Ϣ
	 */
	public Customer queryByCustomerNo(String CustomerNo) ;
	/**
	 * ���ݾ��￨���ҵ�����������������
	 */
	public  List queryAlldate(String CustomerNo);
}
