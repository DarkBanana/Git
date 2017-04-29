package cn.cjpt.mes.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.SysPermissionMapper;
import cn.cjpt.mes.mapper.SysPermissionMapperCustom;
import cn.cjpt.mes.mapper.SysRoleMapper;
import cn.cjpt.mes.mapper.SysRoleMapperCustom;
import cn.cjpt.mes.mapper.SysRolePermissionMapper;
import cn.cjpt.mes.mapper.SysRolePermissionMapperCustom;
import cn.cjpt.mes.pojo.po.SysPermission;
import cn.cjpt.mes.pojo.po.SysPermissionExample;
import cn.cjpt.mes.pojo.po.SysPermissionExample.Criteria;
import cn.cjpt.mes.pojo.po.SysRole;
import cn.cjpt.mes.pojo.po.SysRoleExample;
import cn.cjpt.mes.pojo.po.SysRolePermission;
import cn.cjpt.mes.pojo.po.SysRolePermissionExample;
import cn.cjpt.mes.pojo.vo.SysRoleCustom;
import cn.cjpt.mes.pojo.vo.SysRoleQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.SysRoleService;
import cn.cjpt.mes.shiro.CustomRealm;
import cn.cjpt.mes.util.DateUtil;
import cn.cjpt.mes.util.MenuTree;
import cn.cjpt.mes.util.UUIDBuild;

/**
 * 用户角色 2017年2月20日 上午9:45:18
 * 
 * @author yxf
 */
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapperCustom sysRoleMapperCustom;
	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	@Autowired
	private SysRolePermissionMapperCustom sysRolePermissionMapperCustom;
	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;

	@Autowired
	private CustomRealm customRealm;

	/**
	 * 查询角色 列表
	 */
	@Override
	public List<SysRoleCustom> findSysRoleList(SysRoleQueryVo sysRoleQueryVo)
			throws Exception {

		if (sysRoleQueryVo != null) {
			int page = sysRoleQueryVo.getPageQuery().getPage();
			int rows = sysRoleQueryVo.getPageQuery().getRows();
			// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
			PageHelper.startPage(page, rows);
		}

		return sysRoleMapperCustom.findSysRoleList(sysRoleQueryVo);
	}

	/**
	 * 根据 角色 id 查询 权限
	 */
	@Override
	public List<SysPermission> findPermissionListByRoleId(String roleid)
			throws Exception {
		// TODO Auto-generated method stub
		return sysPermissionMapperCustom.findPermissionListByRoleId(roleid);
	}

	/**
	 * 根据 角色 id 查询 角色和权限 信息
	 */
	@Override
	public SysRoleCustom findRolePermissionByRoleId(String roleid)
			throws Exception {
		// 查询 权限 信息
		List<SysPermission> permissionList = this
				.findPermissionListByRoleId(roleid);
		// 查询 角色信息
		SysRole sysrole_db = sysRoleMapper.selectByPrimaryKey(roleid);
		SysRoleCustom sysRoleCustom = new SysRoleCustom();
		sysRoleCustom.setPermissionList(permissionList);
		sysRoleCustom.setName(sysrole_db.getName());
		sysRoleCustom.setDescribe(sysrole_db.getDescribe());
		sysRoleCustom.setCreatedata(sysrole_db.getCreatedata());
		sysRoleCustom.setAvailable(sysrole_db.getAvailable());
		return sysRoleCustom;
	}

	@Override
	public List<SysPermission> findMenuListByRoleId(String roleid)
			throws Exception {
		// TODO Auto-generated method stub
		return sysPermissionMapperCustom.findMenuListByRoleId(roleid);
	}

	/**
	 * 根据角色 id 返回权限 树
	 */
	@Override
	public List<MenuTree> getrolepermissiontree(String roleid) throws Exception {

		// 权限 表里面的所有 菜单
		List<SysPermission> menuAll = sysPermissionMapperCustom.findMenuAll();
		// 权限 表 里面的权限
		List<SysPermission> permissionAll = sysPermissionMapperCustom
				.findPermissionAll();
		// 角色 对应的 菜单
		List<SysPermission> roleMenu = this.findMenuListByRoleId(roleid);
		// 角色 对应的 权限
		List<SysPermission> rolePermission = this
				.findPermissionListByRoleId(roleid);
		// 返回的 结果集
		List<MenuTree> menuTrees = new ArrayList<MenuTree>();

		for (SysPermission menuPermission : menuAll) {
			// 子节点
			List<MenuTree> childTrees = new ArrayList<MenuTree>();
			// 父节点
			MenuTree menuTree = new MenuTree();
			// menu 的id
			String menuid = menuPermission.getId().toString();
			menuTree.setId(menuid);
			menuTree.setText(menuPermission.getName());
			// 循环遍历。 找到 menu对应的permission
			for (SysPermission permission : permissionAll) {
				String parentid = permission.getParentid().toString();
				if (menuid.equals(parentid)) {
					// 该 permission 属于 该菜单
					MenuTree childmenu = new MenuTree();
					childmenu.setId(permission.getId().toString());
					childmenu.setText(permission.getName());
					// 判断 这个 子节点 角色 是否也有
					for (SysPermission childpermission : rolePermission) {
						if (childpermission.getId().toString()
								.equals(permission.getId().toString())) {
							childmenu.setChecked(true);
						}
					}
					// 将子节点 放到 集合中去
					childTrees.add(childmenu);
				}
			}
			menuTree.setChildren(childTrees);
			menuTrees.add(menuTree);
		}

		// 总的 父节点
		MenuTree menuTreeNode = new MenuTree();
		menuTreeNode.setChildren(menuTrees);
		menuTreeNode.setText("分配权限");
		menuTreeNode.setId("0");

		List<MenuTree> menuTreeResult = new ArrayList<MenuTree>();
		menuTreeResult.add(menuTreeNode);

		return menuTreeResult;

	}

	/**
	 * 修改角色的 权限
	 */
	@Override
	public void editrolepermission_submit(SysPermission[] permissions)
			throws Exception {
		// TODO Auto-generated method stub
		// 借用 parentids 把 roleid 传向了 后台

		int j = permissions.length - 1;

		String roleid = permissions[j].getParentids();
		// 先 删除 有 roleid 的 角色 和权限 关系数据
		sysRolePermissionMapperCustom.deleteByRoleId(roleid);

		for (int i = 0; i < permissions.length; i++) {
			if (permissions[i] != null) {
				SysPermission permission = permissions[i];
				BigDecimal permissionId = permission.getId();
				// 根据 权限 id 查询 对应的权限
				SysPermission permisssion_db = sysPermissionMapper
						.selectByPrimaryKey(permissionId);

				if (permisssion_db != null) {
					/*
					 * ResultUtil.throwExcepion(ResultUtil.createFail(
					 * Config.MESSAGE, 209, null));
					 */
					SysRolePermission sysRolePermission = new SysRolePermission();
					sysRolePermission.setSysRoleId(roleid);
					sysRolePermission.setSysPermissionId(permisssion_db.getId()
							.toString());
					sysRolePermission.setId(new UUIDBuild().getUUID());

					sysRolePermissionMapper.insert(sysRolePermission);
				}
			}
		}
		List<SysPermission> findPermissionListByRoleId = sysPermissionMapperCustom
				.findPermissionListByRoleId(roleid);
		for (SysPermission syspermission : findPermissionListByRoleId) {
			if (syspermission.getType().equals("menu")) {
				String permissionid = syspermission.getId().toString();
				// 查询 sys_role_permission 中是否 有 对应的role 不然，创建
				SysRolePermission menuPermission_db = sysRolePermissionMapper
						.selectByPrimaryKey(permissionid);
				if (menuPermission_db == null) {
					SysRolePermission rolePermission = new SysRolePermission();
					rolePermission.setId(new UUIDBuild().getUUID());
					rolePermission.setSysRoleId(roleid);
					rolePermission.setSysPermissionId(permissionid);
					sysRolePermissionMapper.insert(rolePermission);
				}
			}
			if (syspermission.getType().equals("permission")) {
				String menuid = syspermission.getParentid().toString();
				// 查询 sys_role_permission 中是否 有 对应的role 不然，创建
				SysRolePermission menuPermission_db = sysRolePermissionMapper
						.selectByPrimaryKey(menuid);
				if (menuPermission_db == null) {
					SysRolePermission rolePermission = new SysRolePermission();
					rolePermission.setId(new UUIDBuild().getUUID());
					rolePermission.setSysRoleId(roleid);
					rolePermission.setSysPermissionId(menuid);
					sysRolePermissionMapper.insert(rolePermission);
				}
			}
		}

		// 角色 权限被修改了。 清除缓存，，重新完成用户授权
		customRealm.clearCached();
	}

	/**
	 * 添加 角色
	 */
	@Override
	public void addrole_submit(SysPermission[] permissions) throws Exception {
		int j = permissions.length - 1;
		// 获取 角色 的名称的描述，简单化处理，借助了其他的 字段
		String roleName = permissions[j].getType();
		String roleDescribe = permissions[j].getUrl();

		// 角色 名称 不能重复
		SysRole findSysRoleByRoleName = this.findSysRoleByRoleName(roleName);

		if (findSysRoleByRoleName != null) {
			// 用户 名称重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 210,
					null));
		}

		SysRole sysRole = new SysRole();
		String roleid = new UUIDBuild().getUUID();
		sysRole.setId(roleid);
		sysRole.setName(roleName);
		sysRole.setDescribe(roleDescribe);
		sysRole.setAvailable("1");
		sysRole.setCreatedata(new DateUtil().getNowDateTime());
		// 在 sysrole 表 中添加角色
		sysRoleMapper.insert(sysRole);
		for (int i = 0; i < permissions.length; i++) {
			if (permissions[i] != null) {
				BigDecimal permissionid = permissions[i].getId();
				SysPermission permisssion_db = sysPermissionMapper
						.selectByPrimaryKey(permissionid);
				if (permisssion_db == null) {
					ResultUtil.throwExcepion(ResultUtil.createFail(
							Config.MESSAGE, 209, null));
				}
				SysRolePermission sysRolePermission = new SysRolePermission();
				sysRolePermission.setSysRoleId(roleid);
				sysRolePermission.setSysPermissionId(permisssion_db.getId()
						.toString());
				sysRolePermission.setId(new UUIDBuild().getUUID());
				sysRolePermissionMapper.insert(sysRolePermission);

			}
		}

		List<SysPermission> findPermissionListByRoleId = sysPermissionMapperCustom
				.findPermissionListByRoleId(roleid);
		for (SysPermission syspermission : findPermissionListByRoleId) {
			if (syspermission.getType().equals("menu")) {
				String permissionid = syspermission.getId().toString();
				// 查询 sys_role_permission 中是否 有 对应的role 不然，创建
				SysRolePermission menuPermission_db = sysRolePermissionMapper
						.selectByPrimaryKey(permissionid);
				if (menuPermission_db == null) {
					SysRolePermission rolePermission = new SysRolePermission();
					rolePermission.setId(new UUIDBuild().getUUID());
					rolePermission.setSysRoleId(roleid);
					rolePermission.setSysPermissionId(permissionid);
					sysRolePermissionMapper.insert(rolePermission);
				}
			}
			if (syspermission.getType().equals("permission")) {
				String menuid = syspermission.getParentid().toString();
				// 查询 sys_role_permission 中是否 有 对应的role 不然，创建
				SysRolePermission menuPermission_db = sysRolePermissionMapper
						.selectByPrimaryKey(menuid);
				if (menuPermission_db == null) {
					SysRolePermission rolePermission = new SysRolePermission();
					rolePermission.setId(new UUIDBuild().getUUID());
					rolePermission.setSysRoleId(roleid);
					rolePermission.setSysPermissionId(menuid);
					sysRolePermissionMapper.insert(rolePermission);
				}
			}
		}
		// 角色 权限被修改了。 清除缓存，，重新完成用户授权
		customRealm.clearCached();
	}

	/**
	 * 根据 角色 id 删除 角色
	 */
	@Override
	public void deleteroleById(String roleid) throws Exception {
		// 删除角色
		sysRoleMapper.deleteByPrimaryKey(roleid);
		// 删除 sysRolePermission 中 角色 对应的权限关系
		SysRolePermissionExample example = new SysRolePermissionExample();
		SysRolePermissionExample.Criteria criteria = example.createCriteria();
		criteria.andSysRoleIdEqualTo(roleid);
		// 根据 角色 id 查询到的 sysRolePermission
		List<SysRolePermission> sysRolePermission_db = sysRolePermissionMapper
				.selectByExample(example);
		// 全部 删除
		for (SysRolePermission sysRolePermission : sysRolePermission_db) {
			sysRolePermissionMapper.deleteByPrimaryKey(sysRolePermission
					.getId());
		}
		// 角色 权限被修改了。 清除缓存，，重新完成用户授权
		customRealm.clearCached();
	}

	/**
	 * 根据用户 id 查询 用户角色信息
	 */
	@Override
	public SysRole findSysRoleByUserId(String userid) throws Exception {
		SysRole sysRoleById = sysRoleMapperCustom.findSysRoleByUserId(userid);
		return sysRoleById;
	}

	/**
	 * 根据角色名称 查询 角色
	 */
	@Override
	public SysRole findSysRoleByRoleName(String roleName) throws Exception {
		SysRoleExample sysRoleExample = new SysRoleExample();
		SysRoleExample.Criteria criteria = sysRoleExample.createCriteria();
		criteria.andNameEqualTo(roleName);
		List<SysRole> roleList = sysRoleMapper.selectByExample(sysRoleExample);

		if (roleList != null && roleList.size() == 1) {
			return roleList.get(0);
		}

		return null;
	}
}
