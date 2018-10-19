package server.dao;

import entity.Doctor;

public interface IDoctorDao {
	/**
	 * 根据登陆账号找到医生信息
	 */
	public Doctor queryByDoctorNo(String DoctorNo) ;
	
	/**
	 * 添加员工
	 */
	public void add(Doctor doctorEntity);
	/**
	 * 根据ID删除信息
	 */
	public void delete(int[] id);
	/**
	 * 根据医生编号查找信息
	 */
	public Doctor findByNo(String doctorNo);
	/**
	 * 通过ID查找信息
	 */
	public Doctor findByID(Integer id);
	/**
	 * 修改信息
	 */
	public void edit(Doctor doctorEntity);

}
