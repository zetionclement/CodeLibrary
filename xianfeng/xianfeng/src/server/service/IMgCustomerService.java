package server.service;

import java.rmi.ServerException;

import entity.Customer;


public interface IMgCustomerService {
	/**
	 * 根据ID删除信息
	 */
	public void delete(int[] id);
	/**
	 * 查找客户编码是否重复，不重复就执行添加功能
	 */
	public void add(Customer customerEntity) throws ServerException;
	/**
	 * 通过id查找信息
	 */
	public Customer findByID(Integer id);
	/**
	 * 修改信息
	 */
	public void edit(Customer customerEntity) throws ServerException;

}
