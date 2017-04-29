package cn.cjpt.mes.pojo.vo;

/**
 * 页面 包装类 包装类，用于页面向action传递参数，将数据传到mybatis
 * 
 * @author qiaorenjie
 * 
 */
public class ProcedurecodingQueryVo {
	private ProcedurecodingCustom procedurecodingCustom;
	private PageQuery pageQuery;

	public ProcedurecodingCustom getProcedurecodingCustom() {
		return procedurecodingCustom;
	}

	public void setProcedurecodingCustom(
			ProcedurecodingCustom procedurecodingCustom) {
		this.procedurecodingCustom = procedurecodingCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

}
