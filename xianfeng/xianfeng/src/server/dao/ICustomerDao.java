package server.dao;

import java.util.Date;
import java.util.List;

import entity.Customer;
import entity.Doctor;

public interface ICustomerDao {
	/**
	 * ���ݾ��￨���ҵ��ͻ���Ϣ
	 */
	public Customer queryByCustomerNo(String CustomerNo) ;
	/**
	 * ���ݾ��￨���ҵ�����������������
	 * @return 
	 */
	public  List<Date> queryAlldate(String CustomerNo); 
	/**
	 * ��ӿͻ�
	 */
	public void add(Customer customerEntity);
	/**
	 * ����IDɾ����Ϣ
	 */
	public void delete(int[] id);
	/**
	 * ���ݿͻ���Ų�����Ϣ
	 */
	public Customer findByNo(String customerNo);
	/**
	 * ͨ��ID������Ϣ
	 */
	public Customer findByID(Integer id);
	/**
	 * �޸���Ϣ
	 */
	public void edit(Customer customerEntity);
}
