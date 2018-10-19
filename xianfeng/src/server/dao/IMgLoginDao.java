package server.dao;

import entity.Login;
import entity.ManageLogin;

/**
 * ��̨��½DAO��
 */
public interface IMgLoginDao {
	/**
	 * ���ҹ�������Ϣ
	 */
	public ManageLogin findByName(String admin);
	
	/**
	 * ���ݵ�½�˺��ҵ���½����
	 */
	public Login findLoginPw(String LoginNo);
	
	/**
	 * ��ӵ�¼
	 */
	public void add(Login loginEntity);
	/**
	 * ����IDɾ����Ϣ
	 */
	public void delete(int[] id);
	/**
	 * ���ݵ�¼��Ų�����Ϣ
	 */
	public Login findByNo(String loginNo);
	/**
	 * ͨ��ID������Ϣ
	 * @param id
	 * @return
	 */
	public Login findByID(Integer id);
	/**
	 * �޸���Ϣ
	 */
	public void edit(Login loginEntity);


}
