package cn.cjpt.mes.pojo.vo;

/**
 * 页面 包装类 包装类，用于页面向action传递参数，将数据传到mybatis
 * 
 * @author qiaorenjie
 * 
 */
public class MaintenanceQueryVo {
	private MaintenanceCustom maintenanceCustom;
	private PageQuery pageQuery;

	public MaintenanceCustom getMaintenanceCustom() {
		return maintenanceCustom;
	}

	public void setMaintenanceCustom(MaintenanceCustom maintenanceCustom) {
		this.maintenanceCustom = maintenanceCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

}
