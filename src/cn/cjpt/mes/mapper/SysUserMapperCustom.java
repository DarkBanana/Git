package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.SysUserCustom;
import cn.cjpt.mes.pojo.vo.SysUserQueryVo;

/**
 * 自定义的 SysUserMapper
 * 
 * @author yxf Feb 24, 2017 8:35:34 PM
 * 
 */
public interface SysUserMapperCustom {
	// 查询 所有 系统用户 ，要包括 角色名称
	public List<SysUserCustom> findSysUserList(SysUserQueryVo sysUserQueryVo)
			throws Exception;

	// 查询总数
	public int findSysUserCount(SysUserQueryVo sysUserQueryVo) throws Exception;

}