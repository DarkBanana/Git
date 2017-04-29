package cn.cjpt.mes.pojo.vo;

/**
 * 页面 包装类 包装类，用于页面向action传递参数，将数据传到mybatis
 * 
 * @author qiaorenjie
 * 
 */
public class EquipmentledgerQueryVo {
	private EquipmentledgerCustom equipmentledgerCustom;
	private PageQuery pageQuery;

	public EquipmentledgerCustom getEquipmentledgerCustom() {
		return equipmentledgerCustom;
	}

	public void setEquipmentledgerCustom(
			EquipmentledgerCustom equipmentledgerCustom) {
		this.equipmentledgerCustom = equipmentledgerCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

}
