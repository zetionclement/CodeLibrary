package server.service;

import java.rmi.ServerException;

import entity.Doctor;

public interface IMgDoctorService {
	/**
	 * ����IDɾ����Ϣ
	 */
	public void delete(int[] id);
	/**
	 * ����ҽ�������Ƿ��ظ������ظ���ִ����ӹ���
	 */
	public void add(Doctor callerEntity) throws ServerException;
	/**
	 * ͨ��id������Ϣ
	 */
	public Doctor findByID(Integer id);
	/**
	 * �޸���Ϣ
	 */
	public void edit(Doctor callerEntity) throws ServerException;
}


