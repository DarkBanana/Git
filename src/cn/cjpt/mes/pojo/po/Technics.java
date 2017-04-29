package cn.cjpt.mes.pojo.po;

public class Technics {
	private String id;

	private String technicsname;

	private String technicsmark;

	private String tcname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getTechnicsname() {
		return technicsname;
	}

	public void setTechnicsname(String technicsname) {
		this.technicsname = technicsname == null ? null : technicsname.trim();
	}

	public String getTechnicsmark() {
		return technicsmark;
	}

	public void setTechnicsmark(String technicsmark) {
		this.technicsmark = technicsmark == null ? null : technicsmark.trim();
	}

	public String getTcname() {
		return tcname;
	}

	public void setTcname(String tcname) {
		this.tcname = tcname == null ? null : tcname.trim();
	}
}