package server.dao;

import java.math.BigDecimal;
import java.util.List;

import entity.Medicine;

public interface IMedicineDao {
	/**
	 * ����ҩ���ҵ���ӦҩƷ����
	 * @param <decimal>
	 */
	public BigDecimal findFreeByMedicinesName(String MedicineName);
	/**
	 * ����ҩ��,ʹ����������ӦҩƷ���
	 */
	public void upDateMedicineStock(String MedicineName,int UseCount);
	/**
	 * ���ҩƷ
	 */
	public void add(Medicine medicineEntity);
	/**
	 * ����IDɾ����Ϣ
	 */
	public void delete(int[] id);
	/**
	 * ����ҩƷ��Ų�����Ϣ
	 */
	public Medicine findByNo(String callerNo);
	/**
	 * ͨ��ID������Ϣ
	 * @param id
	 * @return
	 */
	public Medicine findByID(Integer id);
	/**
	 * �޸���Ϣ
	 */
	public void edit(Medicine medicineEntity);
	/**
	 * ���ҵ�����ҩƷ��
	 * @return 
	 */
	public  List FindMedicineName();
	

}
