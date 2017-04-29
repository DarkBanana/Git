package cn.cjpt.mes.pojo.po;

public class Materiel {
	private String id;

	private String materielname;

	private String materielmark;

	private String materielmethod;

	private String materielnumber;

	private String tasktime;

	private String cmodel;

	private String unitname;

	private String unitcode;

	private String cname;

	private String remark1;

	private String remark2;

	private String ctypeid;

	private String ctname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getMaterielname() {
		return materielname;
	}

	public void setMaterielname(String materielname) {
		this.materielname = materielname == null ? null : materielname.trim();
	}

	public String getMaterielmark() {
		return materielmark;
	}

	public void setMaterielmark(String materielmark) {
		this.materielmark = materielmark == null ? null : materielmark.trim();
	}

	public String getMaterielmethod() {
		if (materielmethod.equals("1")) {
			return materielmethod.equals("1") ? "自产" : "外购";
		} else if (materielmethod.equals("自产")) {
			return materielmethod;
		} else if (materielmethod.equals("0")) {
			return materielmethod.equals("0") ? "外购" : "自产";
		} else {
			return "外购";
		}

	}

	public void setMaterielmethod(String materielmethod) {
		this.materielmethod = materielmethod == null ? null : materielmethod
				.trim();
	}

	public String getMaterielnumber() {
		return materielnumber;
	}

	public void setMaterielnumber(String materielnumber) {
		this.materielnumber = materielnumber == null ? null : materielnumber
				.trim();
	}

	public String getTasktime() {
		return tasktime;
	}

	public void setTasktime(String tasktime) {
		this.tasktime = tasktime == null ? null : tasktime.trim();
	}

	public String getCmodel() {
		return cmodel;
	}

	public void setCmodel(String cmodel) {
		this.cmodel = cmodel == null ? null : cmodel.trim();
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname == null ? null : unitname.trim();
	}

	public String getUnitcode() {
		return unitcode;
	}

	public void setUnitcode(String unitcode) {
		this.unitcode = unitcode == null ? null : unitcode.trim();
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname == null ? null : cname.trim();
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

	public String getCtypeid() {
		return ctypeid;
	}

	public void setCtypeid(String ctypeid) {
		this.ctypeid = ctypeid == null ? null : ctypeid.trim();
	}

	public String getCtname() {
		return ctname;
	}

	public void setCtname(String ctname) {
		this.ctname = ctname;
	}

}