package cn.cjpt.mes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.SysPermissionMapperCustom;
import cn.cjpt.mes.pojo.po.SysPermission;
import cn.cjpt.mes.service.SysPermissionService;
import cn.cjpt.mes.util.MenuTree;

/**
 * 权限 service
 * 
 * @author yxf Feb 21, 2017 10:08:15 PM
 * 
 */
public class SysPermissionServiceImpl implements SysPermissionService {

	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;

	/**
	 * 查询所有权限
	 */
	@Override
	public List<SysPermission> findPermissionAll() throws Exception {
		// TODO Auto-generated method stub
		return sysPermissionMapperCustom.findPermissionAll();
	}

	/**
	 * 查询 所有 menu
	 */
	@Override
	public List<SysPermission> findMenuAll() throws Exception {
		// TODO Auto-generated method stub
		return sysPermissionMapperCustom.findMenuAll();
	}

	@Override
	public List<MenuTree> getPermissionTree() throws Exception {
		// 获取 所有的 菜单
		List<SysPermission> findMenuAll = sysPermissionMapperCustom
				.findMenuAll();
		// 获取 所有的 权限
		List<SysPermission> findPermissionAll = sysPermissionMapperCustom
				.findPermissionAll();
		// 返回的 结果集
		List<MenuTree> menuTrees = new ArrayList<MenuTree>();

		for (SysPermission menuPermission : findMenuAll) {
			// 子节点
			List<MenuTree> childTrees = new ArrayList<MenuTree>();
			// 父节点
			MenuTree menuTree = new MenuTree();
			// menu 的id
			String menuid = menuPermission.getId().toString();
			menuTree.setId(menuid);
			menuTree.setText(menuPermission.getName());
			// 循环遍历。 找到 menu对应的permission
			for (SysPermission permission : findPermissionAll) {
				String parentid = permission.getParentid().toString();
				if (menuid.equals(parentid)) {
					// 该 permission 属于 该菜单
					MenuTree childmenu = new MenuTree();
					childmenu.setId(permission.getId().toString());
					childmenu.setText(permission.getName());
					// 判断 这个 子节点 角色 是否也有
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

}
