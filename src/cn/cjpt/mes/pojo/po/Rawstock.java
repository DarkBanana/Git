package cn.cjpt.mes.pojo.po;

public class Rawstock {
	private String id;

	private String rname;

	private String rmodel;

	private String vender;

	private String putstorenum;

	private String outstorenum;

	private String remainnum;

	private String rtime;

	private String remark1;

	private String remark2;

	private String rtid;

	private String rtname;
	private String rttype;
	private String rtvender;
	private String name;
	private String code;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname == null ? null : rname.trim();
	}

	public String getRmodel() {
		return rmodel;
	}

	public void setRmodel(String rmodel) {
		this.rmodel = rmodel == null ? null : rmodel.trim();
	}

	public String getVender() {
		return vender;
	}

	public void setVender(String vender) {
		this.vender = vender == null ? null : vender.trim();
	}

	public String getPutstorenum() {
		return putstorenum;
	}

	public void setPutstorenum(String putstorenum) {
		this.putstorenum = putstorenum == null ? null : putstorenum.trim();
	}

	public String getOutstorenum() {
		return outstorenum;
	}

	public void setOutstorenum(String outstorenum) {
		this.outstorenum = outstorenum == null ? null : outstorenum.trim();
	}

	public String getRemainnum() {
		return remainnum;
	}

	public void setRemainnum(String remainnum) {
		this.remainnum = remainnum == null ? null : remainnum.trim();
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime == null ? null : rtime.trim();
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

	public String getRtid() {
		return rtid;
	}

	public void setRtid(String rtid) {
		this.rtid = rtid == null ? null : rtid.trim();
	}

	public String getRtname() {
		return rtname;
	}

	public void setRtname(String rtname) {
		this.rtname = rtname;
	}

	public String getRttype() {
		return rttype;
	}

	public void setRttype(String rttype) {
		this.rttype = rttype;
	}

	public String getRtvender() {
		return rtvender;
	}

	public void setRtvender(String rtvender) {
		this.rtvender = rtvender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}