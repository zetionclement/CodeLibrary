package server.service;

import java.rmi.ServerException;

import entity.Doctor;

public interface IMgDoctorService {
	/**
	 * 根据ID删除信息
	 */
	public void delete(int[] id);
	/**
	 * 查找医生编码是否重复，不重复就执行添加功能
	 */
	public void add(Doctor callerEntity) throws ServerException;
	/**
	 * 通过id查找信息
	 */
	public Doctor findByID(Integer id);
	/**
	 * 修改信息
	 */
	public void edit(Doctor callerEntity) throws ServerException;
}


