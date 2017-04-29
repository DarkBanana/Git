package cn.cjpt.mes.pojo.po;

public class SysRole {
	private String id;

	private String createdata;

	private String name;

	private String describe;

	private String available;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getCreatedata() {
		return createdata;
	}

	public void setCreatedata(String createdata) {
		this.createdata = createdata == null ? null : createdata.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe == null ? null : describe.trim();
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available == null ? null : available.trim();
	}
}