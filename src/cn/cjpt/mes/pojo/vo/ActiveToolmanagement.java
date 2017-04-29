package cn.cjpt.mes.pojo.vo;

import java.util.Iterator;
import java.util.List;

/**
 * 存入session 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 * 
 * @author qiaorenjie
 * 
 */
public class ActiveToolmanagement implements java.io.Serializable {

	private String id; // 编号

	private String toolname; // 名称

	private String specifications; // 规格型号

	private String toolnumber; // 数量

	private String manufacturer; // 生产厂家

	private String remark; // 备注

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToolname() {
		return toolname;
	}

	public void setToolname(String toolname) {
		this.toolname = toolname;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getToolnumber() {
		return toolnumber;
	}

	public void setToolnumber(String toolnumber) {
		this.toolnumber = toolnumber;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
