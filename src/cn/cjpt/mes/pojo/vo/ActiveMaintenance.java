package cn.cjpt.mes.pojo.vo;

import java.util.Iterator;
import java.util.List;

/**
 * 存入session 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 * 
 * @author qiaorenjie
 * 
 */
public class ActiveMaintenance implements java.io.Serializable {

	private String id; // 编号

	private String toolname; // 名称 ：这里toolname

	private String specifications; // 规格型号

	private String mtime; // 维修保养时间

	private String note; // 维修记录

	private String person; // 维修人员

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

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

}
