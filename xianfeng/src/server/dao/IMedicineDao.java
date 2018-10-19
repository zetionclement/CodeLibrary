package server.dao;

import java.math.BigDecimal;
import java.util.List;

import entity.Medicine;

public interface IMedicineDao {
	/**
	 * 根据药名找到相应药品费用
	 * @param <decimal>
	 */
	public BigDecimal findFreeByMedicinesName(String MedicineName);
	/**
	 * 根据药名,使用量更新相应药品库存
	 */
	public void upDateMedicineStock(String MedicineName,int UseCount);
	/**
	 * 添加药品
	 */
	public void add(Medicine medicineEntity);
	/**
	 * 根据ID删除信息
	 */
	public void delete(int[] id);
	/**
	 * 根据药品编号查找信息
	 */
	public Medicine findByNo(String callerNo);
	/**
	 * 通过ID查找信息
	 * @param id
	 * @return
	 */
	public Medicine findByID(Integer id);
	/**
	 * 修改信息
	 */
	public void edit(Medicine medicineEntity);
	/**
	 * 查找到所以药品名
	 * @return 
	 */
	public  List FindMedicineName();
	

}
