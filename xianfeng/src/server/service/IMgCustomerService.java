package server.service;

import java.rmi.ServerException;

import entity.Customer;


public interface IMgCustomerService {
	/**
	 * ����IDɾ����Ϣ
	 */
	public void delete(int[] id);
	/**
	 * ���ҿͻ������Ƿ��ظ������ظ���ִ����ӹ���
	 */
	public void add(Customer customerEntity) throws ServerException;
	/**
	 * ͨ��id������Ϣ
	 */
	public Customer findByID(Integer id);
	/**
	 * �޸���Ϣ
	 */
	public void edit(Customer customerEntity) throws ServerException;

}
