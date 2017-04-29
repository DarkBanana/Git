package cn.cjpt.mes.pojo.vo;

/**
 * 系统角色包装类，用户页面的条件查询，可以一直传到mybatis 2017年2月20日 上午9:22:47
 * 
 * @author yxf
 */
public class SysRoleQueryVo {
	private SysRoleCustom sysRoleCustom;
	private PageQuery pageQuery;

	public SysRoleCustom getSysRoleCustom() {
		return sysRoleCustom;
	}

	public void setSysRoleCustom(SysRoleCustom sysRoleCustom) {
		this.sysRoleCustom = sysRoleCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

}
