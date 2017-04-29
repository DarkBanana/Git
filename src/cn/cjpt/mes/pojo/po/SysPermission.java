package cn.cjpt.mes.pojo.po;

import java.math.BigDecimal;

public class SysPermission {
	private BigDecimal id;

	private String name;

	private String type;

	private String url;

	private String percode;

	private BigDecimal parentid;

	private String parentids;

	private String sortstring;

	private String available;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode == null ? null : percode.trim();
	}

	public BigDecimal getParentid() {
		return parentid;
	}

	public void setParentid(BigDecimal parentid) {
		this.parentid = parentid;
	}

	public String getParentids() {
		return parentids;
	}

	public void setParentids(String parentids) {
		this.parentids = parentids == null ? null : parentids.trim();
	}

	public String getSortstring() {
		return sortstring;
	}

	public void setSortstring(String sortstring) {
		this.sortstring = sortstring == null ? null : sortstring.trim();
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available == null ? null : available.trim();
	}
}