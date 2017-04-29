package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.po.SysPermission;

/**
 * SysPermissionMapperCustom 自定义 权限 mapper
 * 
 * @author yxf Feb 21, 2017 9:35:56 AM
 * 
 */
public interface SysPermissionMapperCustom {

	// 根据用户id查询菜单
	public List<SysPermission> findMenuListByUserId(String userid)
			throws Exception;

	// 根据角色 id 查询菜单
	public List<SysPermission> findMenuListByRoleId(String roleid)
			throws Exception;

	// 查询所有的 菜单
	public List<SysPermission> findMenuAll() throws Exception;

	// 根据用户id查询权限url
	public List<SysPermission> findPermissionListByUserId(String userid)
			throws Exception;

	// 根据 角色 id 查询 权限
	public List<SysPermission> findPermissionListByRoleId(String roleid)
			throws Exception;

	// 查询 所有的权限
	public List<SysPermission> findPermissionAll() throws Exception;

}
