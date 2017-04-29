package cn.cjpt.mes.pojo.vo;

import cn.cjpt.mes.pojo.po.Procedurecoding;

public class ProcedurecodingCustom extends Procedurecoding {

	private String beginTime;
	private String endTime;
	// 部件名称
	private String materielName;

	public String getMaterielName() {
		return materielName;
	}

	public void setMaterielName(String materielName) {
		this.materielName = materielName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
