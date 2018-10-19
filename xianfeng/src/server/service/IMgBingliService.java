package server.service;

import java.rmi.ServerException;

import entity.Bingli;

public interface IMgBingliService {
	/**
	 * ����IDɾ����Ϣ
	 */
	public void delete(int[] id);
	/**
	 * ����Ա�������Ƿ��ظ������ظ���ִ����ӹ���
	 */
	public void add(Bingli bingliEntity) throws ServerException;
	/**
	 * ͨ��id������Ϣ
	 */
	public Bingli findByID(Integer id);
	/**
	 * �޸���Ϣ
	 */
	public void edit(Bingli bingliEntity) throws ServerException;


}
