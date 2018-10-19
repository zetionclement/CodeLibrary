package server.service;

import java.rmi.ServerException;

import entity.Medicine;

public interface IMgMedicineService {
	/**
	 * 根据ID删除信息
	 */
	public void delete(int[] id);
	/**
	 * 查找员工编码是否重复，不重复就执行添加功能
	 */
	public void add(Medicine medicineEntity) throws ServerException;
	/**
	 * 通过id查找信息
	 */
	public Medicine findByID(Integer id);
	/**
	 * 修改信息
	 */
	public void edit(Medicine medicineEntity) throws ServerException;

}
