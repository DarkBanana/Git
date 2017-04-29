package cn.cjpt.mes.pojo.vo;

/**
 * 页面 包装类 包装类，用于页面向action传递参数，将数据传到mybatis
 * 
 * @author qiaorenjie
 * 
 */
public class ToolmanagementQueryVo {
	private ToolmanagementCustom toolmanagementCustom;
	private PageQuery pageQuery;

	public ToolmanagementCustom getToolmanagementCustom() {
		return toolmanagementCustom;
	}

	public void setToolmanagementCustom(
			ToolmanagementCustom toolmanagementCustom) {
		this.toolmanagementCustom = toolmanagementCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

}
