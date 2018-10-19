package server.dao;

import entity.Login;
import entity.ManageLogin;

/**
 * 后台登陆DAO层
 */
public interface IMgLoginDao {
	/**
	 * 查找管理者信息
	 */
	public ManageLogin findByName(String admin);
	
	/**
	 * 根据登陆账号找到登陆密码
	 */
	public Login findLoginPw(String LoginNo);
	
	/**
	 * 添加登录
	 */
	public void add(Login loginEntity);
	/**
	 * 根据ID删除信息
	 */
	public void delete(int[] id);
	/**
	 * 根据登录编号查找信息
	 */
	public Login findByNo(String loginNo);
	/**
	 * 通过ID查找信息
	 * @param id
	 * @return
	 */
	public Login findByID(Integer id);
	/**
	 * 修改信息
	 */
	public void edit(Login loginEntity);


}
