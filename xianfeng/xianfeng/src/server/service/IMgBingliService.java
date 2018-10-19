package server.service;

import java.rmi.ServerException;

import entity.Bingli;

public interface IMgBingliService {
	/**
	 * 根据ID删除信息
	 */
	public void delete(int[] id);
	/**
	 * 查找员工编码是否重复，不重复就执行添加功能
	 */
	public void add(Bingli bingliEntity) throws ServerException;
	/**
	 * 通过id查找信息
	 */
	public Bingli findByID(Integer id);
	/**
	 * 修改信息
	 */
	public void edit(Bingli bingliEntity) throws ServerException;


}
