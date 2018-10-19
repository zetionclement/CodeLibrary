package server.service;

import java.rmi.ServerException;

import entity.Login;
import entity.ManageLogin;

public interface IMgLoginService {
	public boolean login(ManageLogin managelogin) throws ServerException;
	
	/**
	 * 根据ID删除信息
	 */
	public void delete(int[] id);
	/**
	 * 查找登录编码是否重复，不重复就执行添加功能
	 */
	public void add(Login loginEntity) throws ServerException;
	/**
	 * 通过id查找信息
	 */
	public Login findByID(Integer id);
	/**
	 * 修改信息
	 */
	public void edit(Login loginEntity) throws ServerException;

}
