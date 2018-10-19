package server.dao;

import entity.Doctor;

public interface IDoctorDao {
	/**
	 * ���ݵ�½�˺��ҵ�ҽ����Ϣ
	 */
	public Doctor queryByDoctorNo(String DoctorNo) ;
	
	/**
	 * ���Ա��
	 */
	public void add(Doctor doctorEntity);
	/**
	 * ����IDɾ����Ϣ
	 */
	public void delete(int[] id);
	/**
	 * ����ҽ����Ų�����Ϣ
	 */
	public Doctor findByNo(String doctorNo);
	/**
	 * ͨ��ID������Ϣ
	 */
	public Doctor findByID(Integer id);
	/**
	 * �޸���Ϣ
	 */
	public void edit(Doctor doctorEntity);

}
