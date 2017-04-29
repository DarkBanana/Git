package cn.cjpt.mes.pojo.po;

public class Publishworkorder {
	private String id;

	private String publishworkordenum;

	private String pwonumber;

	private String begintime;

	private String endtime;

	private String orderdecomposeid;

	private String technicsid;

	private String materielname;
	private String technicsname;
	private String ordernum;
	private String finishNum;

	private String unitname;
	private String tcname;
	private String btime;
	private String etime;
	private String cname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getPublishworkordenum() {
		return publishworkordenum;
	}

	public void setPublishworkordenum(String publishworkordenum) {
		this.publishworkordenum = publishworkordenum == null ? null
				: publishworkordenum.trim();
	}

	public String getPwonumber() {
		return pwonumber;
	}

	public void setPwonumber(String pwonumber) {
		this.pwonumber = pwonumber == null ? null : pwonumber.trim();
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime == null ? null : begintime.trim();
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime == null ? null : endtime.trim();
	}

	public String getOrderdecomposeid() {
		return orderdecomposeid;
	}

	public void setOrderdecomposeid(String orderdecomposeid) {
		this.orderdecomposeid = orderdecomposeid == null ? null
				: orderdecomposeid.trim();
	}

	public String getTechnicsid() {
		return technicsid;
	}

	public void setTechnicsid(String technicsid) {
		this.technicsid = technicsid == null ? null : technicsid.trim();
	}

	public String getMaterielname() {
		return materielname;
	}

	public void setMaterielname(String materielname) {
		this.materielname = materielname;
	}

	public String getTechnicsname() {
		return technicsname;
	}

	public void setTechnicsname(String technicsname) {
		this.technicsname = technicsname;
	}

	public String getFinishNum() {
		return finishNum;
	}

	public void setFinishNum(String finishNum) {
		this.finishNum = finishNum;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getTcname() {
		return tcname;
	}

	public void setTcname(String tcname) {
		this.tcname = tcname;
	}

	public String getBtime() {
		return btime;
	}

	public void setBtime(String btime) {
		this.btime = btime;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}