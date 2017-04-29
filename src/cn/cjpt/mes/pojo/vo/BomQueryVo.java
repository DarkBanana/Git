package cn.cjpt.mes.pojo.vo;

/**
 * 用户 页面 包装类 包装类，用于页面向action传递参数，将数据传到mybatis
 * 
 * 
 */
public class BomQueryVo {
	private BomCustom bomCustom;
	private PageQuery pageQuery;

	public BomCustom getBomCustom() {
		return bomCustom;
	}

	public void setBomCustom(BomCustom bomCustom) {
		this.bomCustom = bomCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

}
