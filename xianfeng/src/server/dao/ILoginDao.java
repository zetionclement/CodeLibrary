package server.dao;

import entity.Login;

public interface ILoginDao {
	/**
	 * ���ݵ�½�˺��ҵ���½����
	 */
	public Login findLoginPw(String LoginNo);

}
