package entity;

import java.util.Date;

public class Customer {
	private int id;
	//客户编号
	private String customerNo;
	//客户姓名
	private String customerName;
	//客户性别
	private String customerSex;
	//客户年龄
	private int age;
	//客户身份证
	private String customerPcard;
	//客户电话
	private String customerTel;
	//客户出生日
	private Date customerBoth;
	//客户住址
	private String customerAddress;
	//客户病房号
	private String customerRoomID;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCustomerPcard() {
		return customerPcard;
	}
	public void setCustomerPcard(String customerPcard) {
		this.customerPcard = customerPcard;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public Date getCustomerBoth() {
		return customerBoth;
	}
	public void setCustomerBoth(Date customerBoth) {
		this.customerBoth = customerBoth;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerRoomID() {
		return customerRoomID;
	}
	public void setCustomerRoomID(String customerRoomID) {
		this.customerRoomID = customerRoomID;
	}
	
	
		
	
}
