package cn.cjpt.mes.pojo.vo;

import java.util.ArrayList;
import java.util.List;

public class PlanDetail {
	private String planTotal;
	// 总的 已经完成的
	private String completedNumber;
	// 完成率
	private int completionRate;
	// 今日计划数
	private String planToday;
	// 今日已完成
	private String completedToday;

	List<MaterielCustom> list = new ArrayList<>();

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

	public int getCompletionRate() {
		return completionRate;
	}

	public void setCompletionRate(int completionRate) {
		this.completionRate = completionRate;
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

	public List<MaterielCustom> getList() {
		return list;
	}

	public void setList(List<MaterielCustom> list) {
		this.list = list;
	}

}
