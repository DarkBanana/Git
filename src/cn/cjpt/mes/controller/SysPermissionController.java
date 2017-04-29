package cn.cjpt.mes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.service.SysPermissionService;
import cn.cjpt.mes.util.MenuTree;

@Controller
@RequestMapping("/permission")
public class SysPermissionController {

	@Autowired
	private SysPermissionService sysPermissionService;

	/**
	 * 获取所有 权限的树结构
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getpermissiontree")
	public @ResponseBody
	List<MenuTree> getpermissiontree() throws Exception {
		return sysPermissionService.getPermissionTree();
	}
}
