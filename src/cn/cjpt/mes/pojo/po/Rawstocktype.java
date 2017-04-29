package cn.cjpt.mes.pojo.po;

public class Rawstocktype {
	private String id;

	private String rtname;

	private String rttype;

	private String rtvender;

	private String remark1;

	private String remark2;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getRtname() {
		return rtname;
	}

	public void setRtname(String rtname) {
		this.rtname = rtname == null ? null : rtname.trim();
	}

	public String getRttype() {
		return rttype;
	}

	public void setRttype(String rttype) {
		this.rttype = rttype == null ? null : rttype.trim();
	}

	public String getRtvender() {
		return rtvender;
	}

	public void setRtvender(String rtvender) {
		this.rtvender = rtvender == null ? null : rtvender.trim();
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1 == null ? null : remark1.trim();
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2 == null ? null : remark2.trim();
	}
}