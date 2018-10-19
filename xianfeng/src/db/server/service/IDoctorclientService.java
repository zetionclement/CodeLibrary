package db.server.service;

import entity.Doctor;

/**
	 * 业务模块业务处理层
	 */
	public interface IDoctorclientService {
		/**
		 * 柜员登录
		 * @param username
		 * @param password
		 */
		public boolean login(String LoginNo, String LoginPw);	
		/**
		 * 通过医生工号查找医生信息
		 */
		public Doctor queryByDoctorNo(String doctorNo);
}
