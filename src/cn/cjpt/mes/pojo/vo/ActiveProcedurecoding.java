package cn.cjpt.mes.pojo.vo;

/**
 * 
 * @author qiaorenjie
 * 
 */
public class ActiveProcedurecoding implements java.io.Serializable {

	private String id;

	private String materielcoding;

	private String technicsname;

	private String finishtime;

	private String remark;

	private String materielid;

	private String operator;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaterielcoding() {
		return materielcoding;
	}

	public void setMaterielcoding(String materielcoding) {
		this.materielcoding = materielcoding;
	}

	public String getTechnicsname() {
		return technicsname;
	}

	public void setTechnicsname(String technicsname) {
		this.technicsname = technicsname;
	}

	public String getFinishtime() {
		return finishtime;
	}

	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMaterielid() {
		return materielid;
	}

	public void setMaterielid(String materielid) {
		this.materielid = materielid;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
