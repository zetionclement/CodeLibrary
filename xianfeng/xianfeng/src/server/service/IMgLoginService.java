package server.service;

import java.rmi.ServerException;

import entity.Login;
import entity.ManageLogin;

public interface IMgLoginService {
	public boolean login(ManageLogin managelogin) throws ServerException;
	
	/**
	 * ����IDɾ����Ϣ
	 */
	public void delete(int[] id);
	/**
	 * ���ҵ�¼�����Ƿ��ظ������ظ���ִ����ӹ���
	 */
	public void add(Login loginEntity) throws ServerException;
	/**
	 * ͨ��id������Ϣ
	 */
	public Login findByID(Integer id);
	/**
	 * �޸���Ϣ
	 */
	public void edit(Login loginEntity) throws ServerException;

}
