package server.rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Doctor;

public class DoctorRowsMapper implements RowsMapper<Doctor> {
	public Doctor getEntity(ResultSet rs) throws SQLException{
		
		Doctor doctor = new Doctor();
		doctor.setId(rs.getInt("D_ID"));
		doctor.setDoctorNo(rs.getString("D_No"));
		doctor.setDoctorName(rs.getString("D_Name"));
		doctor.setDoctorSex(rs.getString("D_Sex"));
		doctor.setDoctorTel(rs.getString("D_Tel"));
		doctor.setSectionName(rs.getString("S_Name"));
		doctor.setDoctorEduction(rs.getString("D_Education"));
		doctor.setDoctorIntroduce(rs.getString("D_Introduce"));
		doctor.setDootorHiredate(rs.getDate("D_hiredate"));
		doctor.setDoctorAge(rs.getInt("D_Age"));
		doctor.setDoctorPcard(rs.getString("D_Pcard"));

		return doctor;
	}

}
