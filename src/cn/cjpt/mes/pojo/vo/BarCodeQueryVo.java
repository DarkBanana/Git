package cn.cjpt.mes.pojo.vo;

public class BarCodeQueryVo {
	private PageQuery pageQuery;
	private BarCodeCustom barCodeCustom;

	public BarCodeCustom getBarCodeCustom() {
		return barCodeCustom;
	}

	public void setBarCodeCustom(BarCodeCustom barCodeCustom) {
		this.barCodeCustom = barCodeCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

}
