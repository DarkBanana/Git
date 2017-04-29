package cn.cjpt.mes.pojo.vo;

import cn.cjpt.mes.pojo.po.Technics;

/**
 * 扩展 Technics 类
 * 
 * @author yxf 2017年3月17日 下午2:21:47
 * 
 */
public class TechnicsCustom extends Technics {

	// 工艺 又 对应 工位信息
	private String planTotal; // 总计划数
	private String completedNumber; // 已完成 数
	private String planToday; // 今日计划数
	private String completedToday; // 今日 已完成

	public String getPlanTotal() {
		return planTotal;
	}

	public void setPlanTotal(String planTotal) {
		this.planTotal = planTotal;
	}

	public String getCompletedNumber() {
		return completedNumber;
	}

	public void setCompletedNumber(String completedNumber) {
		this.completedNumber = completedNumber;
	}

	public String getPlanToday() {
		return planToday;
	}

	public void setPlanToday(String planToday) {
		this.planToday = planToday;
	}

	public String getCompletedToday() {
		return completedToday;
	}

	public void setCompletedToday(String completedToday) {
		this.completedToday = completedToday;
	}

}
