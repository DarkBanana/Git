package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.SysPermission;
import cn.cjpt.mes.util.MenuTree;

/**
 * 权限 server
 * 
 * @author yxf Feb 21, 2017 10:06:24 PM
 * 
 */
public interface SysPermissionService {

	// 查询 所有的权限
	public List<SysPermission> findPermissionAll() throws Exception;

	// 查询所有的 菜单
	public List<SysPermission> findMenuAll() throws Exception;

	// 获取 所有 权限 的 tree
	public List<MenuTree> getPermissionTree() throws Exception;
}
