package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.po.SysRole;
import cn.cjpt.mes.pojo.vo.SysRoleCustom;
import cn.cjpt.mes.pojo.vo.SysRoleQueryVo;

/**
 * 自定义 的 roleMapper 接口 2017年2月20日 上午9:17:48
 * 
 * @author yxf
 */
public interface SysRoleMapperCustom {

	// 查询用户列表
	public List<SysRoleCustom> findSysRoleList(SysRoleQueryVo sysRoleQueryVo)
			throws Exception;

	// 根据 用户 id 查询 用户 角色
	public SysRole findSysRoleByUserId(String userid) throws Exception;
}
