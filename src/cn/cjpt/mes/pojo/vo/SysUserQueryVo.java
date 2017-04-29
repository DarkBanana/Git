package cn.cjpt.mes.pojo.vo;

/**
 * 系统角色包装类，用户页面的条件查询，可以一直传到mybatis 2017年2月20日 上午9:22:47
 * 
 * @author yxf
 */
public class SysUserQueryVo {
	private SysUserCustom sysUserCustom;
	private PageQuery pageQuery;

	public SysUserCustom getSysUserCustom() {
		return sysUserCustom;
	}

	public void setSysUserCustom(SysUserCustom sysUserCustom) {
		this.sysUserCustom = sysUserCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

}
