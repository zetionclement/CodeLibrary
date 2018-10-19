package server.dao;

import java.util.Date;
import java.util.List;

import entity.Customer;
import entity.Doctor;

public interface ICustomerDao {
	/**
	 * 根据就诊卡号找到客户信息
	 */
	public Customer queryByCustomerNo(String CustomerNo) ;
	/**
	 * 根据就诊卡号找到所以曾经就诊日期
	 * @return 
	 */
	public  List<Date> queryAlldate(String CustomerNo); 
	/**
	 * 添加客户
	 */
	public void add(Customer customerEntity);
	/**
	 * 根据ID删除信息
	 */
	public void delete(int[] id);
	/**
	 * 根据客户编号查找信息
	 */
	public Customer findByNo(String customerNo);
	/**
	 * 通过ID查找信息
	 */
	public Customer findByID(Integer id);
	/**
	 * 修改信息
	 */
	public void edit(Customer customerEntity);
}
