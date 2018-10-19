package entity;

public class PageEntity {
	private int ID;
	private String type;
	private String name;
	private int limitNo;
	private String remark;
	
	public PageEntity() {
		super();
	}
	
	public PageEntity(int iD, String type, String name, int limitNo, String remark) {
		super();
		ID = iD;
		this.type = type;
		this.name = name;
		this.limitNo = limitNo;
		this.remark = remark;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLimitNo() {
		return limitNo;
	}

	public void setLimitNo(int limitNo) {
		this.limitNo = limitNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
