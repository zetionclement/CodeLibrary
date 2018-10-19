package server.service;

import java.rmi.ServerException;

import entity.Medicine;

public interface IMgMedicineService {
	/**
	 * ����IDɾ����Ϣ
	 */
	public void delete(int[] id);
	/**
	 * ����Ա�������Ƿ��ظ������ظ���ִ����ӹ���
	 */
	public void add(Medicine medicineEntity) throws ServerException;
	/**
	 * ͨ��id������Ϣ
	 */
	public Medicine findByID(Integer id);
	/**
	 * �޸���Ϣ
	 */
	public void edit(Medicine medicineEntity) throws ServerException;

}
