package entity;

import java.math.BigDecimal;

public class Medicine {
	private int id;
	//药品编号
	private String medicineNo;
	//药品名字
	private String medicineName;
	//药品类型
	private String medicineType;
	//药品费用名
	private String freeName;
	//药品指导
	private String medicineGuige;
	//药品剂型
	private String medicineJixing;
	//药品途径
	private String medicineWay;
	//药品费用
	private BigDecimal medicineFree;
	//药品库存
	private int Stock;
	//药品功能
	private String medicineFunction;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMedicineNo() {
		return medicineNo;
	}
	public void setMedicineNo(String medicineNo) {
		this.medicineNo = medicineNo;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineType() {
		return medicineType;
	}
	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}
	public String getFreeName() {
		return freeName;
	}
	public void setFreeName(String freeName) {
		this.freeName = freeName;
	}
	public String getMedicineGuige() {
		return medicineGuige;
	}
	public void setMedicineGuige(String medicineGuige) {
		this.medicineGuige = medicineGuige;
	}
	public String getMedicineJixing() {
		return medicineJixing;
	}
	public void setMedicineJixing(String medicineJixing) {
		this.medicineJixing = medicineJixing;
	}
	public String getMedicineWay() {
		return medicineWay;
	}
	public void setMedicineWay(String medicineWay) {
		this.medicineWay = medicineWay;
	}
	public BigDecimal getMedicineFree() {
		return medicineFree;
	}
	public void setMedicineFree(BigDecimal medicineFree) {
		this.medicineFree = medicineFree;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public String getMedicineFunction() {
		return medicineFunction;
	}
	public void setMedicineFunction(String medicineFunction) {
		this.medicineFunction = medicineFunction;
	}
	
}
