package cn.cjpt.mes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.cjpt.mes.pojo.po.SysPermission;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.SysRoleCustom;
import cn.cjpt.mes.pojo.vo.SysRoleQueryVo;
import cn.cjpt.mes.pojo.vo.SysUserCustom;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.SysPermissionService;
import cn.cjpt.mes.service.SysRoleService;
import cn.cjpt.mes.util.MenuTree;

/**
 * 用户角色 2017年2月20日 上午9:46:30
 * 
 * @author yxf
 */
@Controller
@RequestMapping("/role")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	SysPermissionService sysPermissionService;

	/**
	 * 显示 角色 页面
	 * 
	 * @return
	 */
	@RequestMapping("/queryrole")
	/* @RequiresPermissions("user:create") */
	public String queryrole() {
		return "/base/role/queryrole";
	}

	@RequestMapping("/queryrole_resule")
	public @ResponseBody
	DataGridResultInfo queryrole(SysRoleQueryVo sysRoleQueryVo, int page,// 显示第几页
			int rows // 每一页显示个数
	) throws Exception {
		// 非空校验
		sysRoleQueryVo = sysRoleQueryVo != null ? sysRoleQueryVo
				: new SysRoleQueryVo();
		PageQuery pageQuery = new PageQuery(page, rows);

		sysRoleQueryVo.setPageQuery(pageQuery);

		List<SysRoleCustom> roleList = sysRoleService
				.findSysRoleList(sysRoleQueryVo);

		PageInfo<SysRoleCustom> pageInfo = new PageInfo<>(roleList);
		int total = (int) pageInfo.getTotal();
		// 将数据 放到 DataGridResultInfo 中去
		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		dataGridResultInfo.setRows(roleList);
		// 填充 total
		dataGridResultInfo.setTotal(total);
		dataGridResultInfo.setTotal(rows);
		return dataGridResultInfo;
	}

	/**
	 * 显示 修改 角色 页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editrole")
	public String editrole(Model model, String id) throws Exception {

		SysRoleCustom sysroleCustom = sysRoleService
				.findRolePermissionByRoleId(id);
		// 将数据写到 model 中去
		model.addAttribute("sysroleCustom", sysroleCustom);

		return "/base/role/editrole";
	}

	/**
	 * 根据 角色 id 获取权限 树
	 * 
	 * @param roleid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getrolepermissiontree")
	public @ResponseBody
	List<MenuTree> getrolepermissiontree(String roleid) throws Exception {
		return sysRoleService.getrolepermissiontree(roleid);
	}

	@RequestMapping("/editrolepermission_submit")
	public @ResponseBody
	SubmitResultInfo editrolepermission_submit(
			@RequestBody SysPermission[] permissions) throws Exception {

		sysRoleService.editrolepermission_submit(permissions);

		// 默认为成功
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

	/**
	 * addrole
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addrole")
	public String addrole() throws Exception {

		return "/base/role/addrole";
	}

	/**
	 * 添加角色 数据提交
	 * 
	 * @param sysRoleQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addrole_submit")
	public @ResponseBody
	SubmitResultInfo addrole_submit(@RequestBody SysPermission[] permissions)
			throws Exception {

		sysRoleService.addrole_submit(permissions);

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

	@RequestMapping("/deleterole")
	public @ResponseBody
	SubmitResultInfo deleterole(String id) throws Exception {
		sysRoleService.deleteroleById(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

}
