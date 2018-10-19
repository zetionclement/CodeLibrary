package db.server.service.impl;

import db.server.service.IDoctorclientService;
import entity.Doctor;
import entity.Login;
import server.dao.IDoctorDao;
import server.dao.ILoginDao;
import server.dao.impl.DoctorDaoImpl;
import server.dao.impl.LoginDaoImpl;


public class DoctorLoginImpl implements IDoctorclientService {
	
	private ILoginDao logindao = new LoginDaoImpl();
	private IDoctorDao doctordao = new DoctorDaoImpl();
	@Override
	public boolean login(String loginNo, String loginpassword) {
	    Login login = logindao.findLoginPw(loginNo);
		if(null != login && login.getLoginPw().equals(loginpassword)){
			return true;
		}else{
			return false;
		}
		// TODO Auto-generated method stub	
	}
	@Override
	public Doctor queryByDoctorNo(String doctorNo) {
		return doctordao.queryByDoctorNo(doctorNo);
	    }	
}


