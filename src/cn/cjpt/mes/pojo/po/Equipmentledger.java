package cn.cjpt.mes.pojo.po;

public class Equipmentledger {
	private String id; // 编号

	private String toolname; // 名称 tool

	private String specifications; // 规格型号

	private String toolnumber; // 数量 tool

	private String manufacturer; // 生产厂家

	private String purchasedate; // 购买日期

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getToolname() {
		return toolname;
	}

	public void setToolname(String toolname) {
		this.toolname = toolname == null ? null : toolname.trim();
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications == null ? null : specifications
				.trim();
	}

	public String getToolnumber() {
		return toolnumber;
	}

	public void setToolnumber(String toolnumber) {
		this.toolnumber = toolnumber == null ? null : toolnumber.trim();
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer == null ? null : manufacturer.trim();
	}

	public String getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate == null ? null : purchasedate.trim();
	}
}