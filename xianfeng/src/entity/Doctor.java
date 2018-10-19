package entity;

import java.util.Date;

public class Doctor {
	private int id ;
	//医生编号
	private String doctorNo;
	//医生姓名
	private String doctorName;
	//医生性别
	private String doctorSex;
	//医生电话
	private String doctorTel;
	//科室名字
	private String sectionName;
	//医生学历
	private String doctorEduction;
	//医生简介
	private String doctorIntroduce;
	//医生入职时间
	private Date dootorHiredate;
	//医生年龄
	private int doctorAge;
	//医生身份证号
	private String doctorPcard;
	public String getDoctorPcard() {
		return doctorPcard;
	}
	public void setDoctorPcard(String doctorPcard) {
		this.doctorPcard = doctorPcard;
	}
	public int getDoctorAge() {
		return doctorAge;
	}
	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoctorNo() {
		return doctorNo;
	}
	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorSex() {
		return doctorSex;
	}
	public void setDoctorSex(String doctorSex) {
		this.doctorSex = doctorSex;
	}
	public String getDoctorTel() {
		return doctorTel;
	}
	public void setDoctorTel(String doctorTel) {
		this.doctorTel = doctorTel;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getDoctorEduction() {
		return doctorEduction;
	}
	public void setDoctorEduction(String doctorEduction) {
		this.doctorEduction = doctorEduction;
	}
	public String getDoctorIntroduce() {
		return doctorIntroduce;
	}
	public void setDoctorIntroduce(String doctorIntroduce) {
		this.doctorIntroduce = doctorIntroduce;
	}
	public Date getDootorHiredate() {
		return dootorHiredate;
	}
	public void setDootorHiredate(Date dootorHiredate) {
		this.dootorHiredate = dootorHiredate;
	}

}
