package entity;

import java.math.BigDecimal;
import java.util.Date;

public class Bingli {
	private int id;
	//客户编号
	private String customerNo;
	//医生编号
	private String doctorNo;
	//就诊时间
	private Date time;
	//就诊结果
	private String result;
	//药方
	private String plan;
	//费用
	private BigDecimal free;
	//是否成功
	private String isscuccess;
	//原因
	private String reason;
	public String getIsscuccess() {
		return isscuccess;
	}
	public void setIsscuccess(String isscuccess) {
		this.isscuccess = isscuccess;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getDoctorNo() {
		return doctorNo;
	}
	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public BigDecimal getFree() {
		return free;
	}
	public void setFree(BigDecimal free) {
		this.free = free;
	}
	

}
