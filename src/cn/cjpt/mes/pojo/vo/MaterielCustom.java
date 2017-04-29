package cn.cjpt.mes.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import cn.cjpt.mes.pojo.po.Materiel;

public class MaterielCustom extends Materiel {

	// 部件 又 对应 工位信息
	private String planTotal; // 总计划数
	private String completedNumber; // 已完成 数
	private String planToday; // 今日计划数
	private String completedToday; // 今日 已完成
	private String completionRate; // 完成率

	List<MaterielCustom> partsPlanList = new ArrayList<>();

	public List<MaterielCustom> getPartsPlanList() {
		return partsPlanList;
	}

	public void setPartsPlanList(List<MaterielCustom> partsPlanList) {
		this.partsPlanList = partsPlanList;
	}

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

	public String getCompletionRate() {
		return completionRate;
	}

	public void setCompletionRate(String completionRate) {
		this.completionRate = completionRate;
	}

	public MaterielCustom(String planTotal, String completedNumber,
			String planToday, String completedToday, String completionRate,
			List<MaterielCustom> partsPlanList) {
		super();
		this.planTotal = planTotal;
		this.completedNumber = completedNumber;
		this.planToday = planToday;
		this.completedToday = completedToday;
		this.completionRate = completionRate;
		this.partsPlanList = partsPlanList;
	}

	public MaterielCustom() {
		super();
	}

}
