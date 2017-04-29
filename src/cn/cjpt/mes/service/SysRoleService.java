package cn.cjpt.mes.service;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.pojo.po.SysPermission;
import cn.cjpt.mes.pojo.po.SysRole;
import cn.cjpt.mes.pojo.vo.SysRoleCustom;
import cn.cjpt.mes.pojo.vo.SysRoleQueryVo;
import cn.cjpt.mes.util.MenuTree;

/**
 * 角色管理 2017年2月19日 下午10:04:49
 * 
 * @author yxf
 */
public interface SysRoleService {

	// 查询用户列表
	public List<SysRoleCustom> findSysRoleList(SysRoleQueryVo sysRoleQueryVo)
			throws Exception;

	// 根据 角色 id 查询权限
	public List<SysPermission> findPermissionListByRoleId(String roleid)
			throws Exception;

	// 根据 角色 id 查询 角色 和权限信息
	public SysRoleCustom findRolePermissionByRoleId(String roleid)
			throws Exception;

	// 根据角色 id 查询菜单
	public List<SysPermission> findMenuListByRoleId(String roleid)
			throws Exception;

	// 根据 角色 名查找角色信息
	public SysRole findSysRoleByRoleName(String roleName) throws Exception;

	// 根据 角色 id 返回 权限 树
	public List<MenuTree> getrolepermissiontree(String roleid) throws Exception;

	// 修改 角色 的 权限
	public void editrolepermission_submit(SysPermission[] permissions)
			throws Exception;

	// 添加 角色
	public void addrole_submit(SysPermission[] permissions) throws Exception;

	// 根据 角色 id 删除角色
	public void deleteroleById(String roleid) throws Exception;

	// 根据 用户 id 查询用户信息
	public SysRole findSysRoleByUserId(String userid) throws Exception;

}
