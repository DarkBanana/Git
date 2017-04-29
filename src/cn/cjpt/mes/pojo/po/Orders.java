package cn.cjpt.mes.pojo.po;

public class Orders {
	private String id;

	private String ordernum;

	private String ordercontract;

	private String cabinetnumber;

	private String begintime;

	private String endtime;

	private String ordernature;

	private String orderpriority;

	private String loadcenter;

	private String modeproduction;

	private String materielmark;

	private String technicsmark;

	private String materieltype;

	private String remark;// 订单未分解时为null，当订单分解完成后为1
	private String btime;
	private String etime;
	private String cname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum == null ? null : ordernum.trim();
	}

	public String getOrdercontract() {
		return ordercontract;
	}

	public void setOrdercontract(String ordercontract) {
		this.ordercontract = ordercontract == null ? null : ordercontract
				.trim();
	}

	public String getCabinetnumber() {
		return cabinetnumber;
	}

	public void setCabinetnumber(String cabinetnumber) {
		this.cabinetnumber = cabinetnumber == null ? null : cabinetnumber
				.trim();
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

	public String getOrdernature() {
		return ordernature;
	}

	public void setOrdernature(String ordernature) {
		this.ordernature = ordernature == null ? null : ordernature.trim();
	}

	public String getOrderpriority() {
		return orderpriority;
	}

	public void setOrderpriority(String orderpriority) {
		this.orderpriority = orderpriority == null ? null : orderpriority
				.trim();
	}

	public String getLoadcenter() {
		return loadcenter;
	}

	public void setLoadcenter(String loadcenter) {
		this.loadcenter = loadcenter == null ? null : loadcenter.trim();
	}

	public String getModeproduction() {
		return modeproduction;
	}

	public void setModeproduction(String modeproduction) {
		this.modeproduction = modeproduction == null ? null : modeproduction
				.trim();
	}

	public String getMaterielmark() {
		return materielmark;
	}

	public void setMaterielmark(String materielmark) {
		this.materielmark = materielmark == null ? null : materielmark.trim();
	}

	public String getTechnicsmark() {
		return technicsmark;
	}

	public void setTechnicsmark(String technicsmark) {
		this.technicsmark = technicsmark == null ? null : technicsmark.trim();
	}

	public String getMaterieltype() {
		return materieltype;
	}

	public void setMaterieltype(String materieltype) {
		this.materieltype = materieltype == null ? null : materieltype.trim();
	}

	public String getRemark() {
		if (remark == null || remark.equals("") || remark.equals("未分解")) {
			return "未分解";
		} else {
			return "已分解";
		}
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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

}