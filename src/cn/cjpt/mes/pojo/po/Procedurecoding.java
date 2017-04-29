package cn.cjpt.mes.pojo.po;

public class Procedurecoding {
	private String id; // id

	private String materielcoding; // 编码

	private String technicsname; // 工艺

	private String finishtime; // 作业时间

	private String remark; // 备注

	private String materielid; // 物料编码

	private String operator; // 作业人员

	// 增加
	private String unitname; // 物料名字

	private String countnum; // 数量

	private String pc; // 存放pc 存放在制品

	private String tcname; // 作业区域 （汉语名称）
	private String mname; // ajax刷code出来的名称
	private String todaytime;
	private String materielmark;
	private String odnumber;// 用来接收数据
	private String cabinettype;//
	private String begintime;//工位查询开始时间
	 private String endtime;//工位查询结束时间
	public String getTcname() {
		return tcname;
	}

	public void setTcname(String tcname) {
		this.tcname = tcname;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getMaterielcoding() {
		return materielcoding;
	}

	public void setMaterielcoding(String materielcoding) {
		this.materielcoding = materielcoding == null ? null : materielcoding
				.trim();
	}

	public String getTechnicsname() {
		return technicsname;
	}

	public void setTechnicsname(String technicsname) {
		this.technicsname = technicsname == null ? null : technicsname.trim();
	}

	public String getFinishtime() {
		return finishtime;
	}

	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime == null ? null : finishtime.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getMaterielid() {
		return materielid;
	}

	public void setMaterielid(String materielid) {
		this.materielid = materielid == null ? null : materielid.trim();
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getCountnum() {
		return countnum;
	}

	public void setCountnum(String countnum) {
		this.countnum = countnum;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getTodaytime() {
		return todaytime;
	}

	public void setTodaytime(String todaytime) {
		this.todaytime = todaytime;
	}

	public String getMaterielmark() {
		return materielmark;
	}

	public void setMaterielmark(String materielmark) {
		this.materielmark = materielmark;
	}

	public String getOdnumber() {
		return odnumber;
	}

	public void setOdnumber(String odnumber) {
		this.odnumber = odnumber;
	}

	public String getCabinettype() {
		return cabinettype;
	}

	public void setCabinettype(String cabinettype) {
		this.cabinettype = cabinettype;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}