package cn.cjpt.mes.pojo.vo;

import cn.cjpt.mes.mapper.CtypeMapper;

public class CtypeQueryVo {
	private CtypeCustom ctypeCustom;
	private PageQuery pageQuery;

	public CtypeCustom getCtypeCustom() {
		return ctypeCustom;
	}

	public void setCtypeCustom(CtypeCustom ctypeCustom) {
		this.ctypeCustom = ctypeCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

}
