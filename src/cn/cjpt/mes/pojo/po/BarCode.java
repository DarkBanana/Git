package cn.cjpt.mes.pojo.po;

public class BarCode {
	private String id;

	private String barcodenumber;

	private String name;

	private String types;

	private String cabinettype;

	private String createtime;

	private String operatorname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getBarcodenumber() {
		return barcodenumber;
	}

	public void setBarcodenumber(String barcodenumber) {
		this.barcodenumber = barcodenumber == null ? null : barcodenumber
				.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types == null ? null : types.trim();
	}

	public String getCabinettype() {
		return cabinettype;
	}

	public void setCabinettype(String cabinettype) {
		this.cabinettype = cabinettype == null ? null : cabinettype.trim();
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime == null ? null : createtime.trim();
	}

	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname == null ? null : operatorname.trim();
	}
}