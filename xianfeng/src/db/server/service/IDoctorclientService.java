package db.server.service;

import entity.Doctor;

/**
	 * ҵ��ģ��ҵ�����
	 */
	public interface IDoctorclientService {
		/**
		 * ��Ա��¼
		 * @param username
		 * @param password
		 */
		public boolean login(String LoginNo, String LoginPw);	
		/**
		 * ͨ��ҽ�����Ų���ҽ����Ϣ
		 */
		public Doctor queryByDoctorNo(String doctorNo);
}
