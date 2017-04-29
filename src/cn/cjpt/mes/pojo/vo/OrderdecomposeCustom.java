package cn.cjpt.mes.pojo.vo;

import cn.cjpt.mes.pojo.po.Orderdecompose;

public class OrderdecomposeCustom extends Orderdecompose {

	private String unitname;

	private String materielname;

	private String nowTime;

	public String getNowTime() {
		return nowTime;
	}

	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getMaterielname() {
		return materielname;
	}

	public void setMaterielname(String materielname) {
		this.materielname = materielname;
	}

}
