package cn.cjpt.mes.pojo.po;

public class Maintenance {
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

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime == null ? null : mtime.trim();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person == null ? null : person.trim();
	}
}