package cn.cjpt.mes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.pojo.po.SysRole;
import cn.cjpt.mes.pojo.po.SysUser;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.SysRoleCustom;
import cn.cjpt.mes.pojo.vo.SysUserCustom;
import cn.cjpt.mes.pojo.vo.SysUserQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.SysRoleService;
import cn.cjpt.mes.service.SysUserService;

import com.github.pagehelper.PageInfo;

/**
 * 系统 用户
 * 
 * @author yxf Feb 24, 2017 9:02:56 PM
 * 
 */

@Controller
@RequestMapping("/user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	SysRoleService sysRoleService;

	/**
	 * 跳转到 queryuser 页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryuser")
	public String queryuser() throws Exception {

		return "/base/user/queryuser";
	}

	/**
	 * 查询 系统用户 列表
	 * 
	 * @param sysUserQueryVo
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryuser_submit")
	public @ResponseBody
	DataGridResultInfo findSysUserList(SysUserQueryVo sysUserQueryVo,
			Integer page,// 页码
			Integer rows// 每页显示个数
	) throws Exception {
		// 非空校验
		sysUserQueryVo = sysUserQueryVo != null ? sysUserQueryVo
				: new SysUserQueryVo();

		PageQuery pageQuery = new PageQuery(page, rows);

		sysUserQueryVo.setPageQuery(pageQuery);
		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<SysUserCustom> list = sysUserService
				.findSysUserList(sysUserQueryVo);

		PageInfo<SysUserCustom> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);
		return dataGridResultInfo;
	}

	/**
	 * 修改用户信息 数据显示
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edituser")
	public String edituser(Model model, String id) throws Exception {
		// 查询 用户信息
		SysUser sysuser_db = sysUserService.findSysUserById(id);
		if (sysuser_db == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 204,
					null));
		}
		// 所有的 的 角色信息
		List<SysRoleCustom> sysRoleCustomList = sysRoleService
				.findSysRoleList(null);
		List<SysRole> roleList = new ArrayList<SysRole>();
		// 将sysRoleCustomList 中的数据放到 sysRole 中
		if (sysRoleCustomList != null) {
			for (SysRoleCustom sysRoleCustom : sysRoleCustomList) {
				SysRole sysRole = new SysRole();
				sysRole.setId(sysRoleCustom.getId());
				sysRole.setName(sysRoleCustom.getName());
				roleList.add(sysRole);
			}
		}
		SysUserCustom sysUserCustom = new SysUserCustom();
		// 查询 用户 对应的 角色 信息
		SysRole findSysRoleById = sysRoleService.findSysRoleByUserId(id);
		/*
		 * if (findSysRoleById != null) {
		 * sysUserCustom.setRoleName(findSysRoleById.getName()); } else {
		 * sysUserCustom.setRoleName("--请选择--"); }
		 */
		sysUserCustom.setRoleList(roleList);

		sysUserCustom.setAge(sysuser_db.getAge());
		sysUserCustom.setDepartment(sysuser_db.getDepartment());
		sysUserCustom.setId(sysuser_db.getId());
		sysUserCustom.setJobnumber(sysuser_db.getJobnumber());
		sysUserCustom.setPositionaltitles(sysuser_db.getPositionaltitles());
		sysUserCustom.setSex(sysuser_db.getSex());
		sysUserCustom.setTel(sysuser_db.getTel());
		sysUserCustom.setUsercode(sysuser_db.getUsercode());
		sysUserCustom.setUsername(sysuser_db.getUsername());
		sysUserCustom.setWorktype(sysuser_db.getWorktype());
		model.addAttribute("sysUserCustom", sysUserCustom);

		return "/base/user/edituser";
	}

	/**
	 * 用户 信息 修改 提交
	 * 
	 * @return
	 */
	@RequestMapping("/edituser_submit")
	public @ResponseBody
	SubmitResultInfo edituser_submit(String id, SysUserQueryVo sysUserQueryVo)
			throws Exception {

		sysUserService.updateSysUser(id, sysUserQueryVo.getSysUserCustom());

		// 默认为成功
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

	/**
	 * 添加 用户
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/adduser")
	public String adduser(Model model) throws Exception {

		// 所有的 的 角色信息
		List<SysRoleCustom> sysRoleCustomList = sysRoleService
				.findSysRoleList(null);
		List<SysRole> roleList = new ArrayList<SysRole>();
		// 将sysRoleCustomList 中的数据放到 sysRole 中
		if (sysRoleCustomList != null) {
			for (SysRoleCustom sysRoleCustom : sysRoleCustomList) {
				SysRole sysRole = new SysRole();
				sysRole.setId(sysRoleCustom.getId());
				sysRole.setName(sysRoleCustom.getName());
				roleList.add(sysRole);
			}
		}
		SysUserCustom sysUserCustom = new SysUserCustom();
		sysUserCustom.setRoleList(roleList);

		model.addAttribute("sysUserCustom", sysUserCustom);

		return "/base/user/adduser";
	}

	@RequestMapping("/adduser_submit")
	public @ResponseBody
	SubmitResultInfo adduser_submit(SysUserQueryVo syUserQueryVo)
			throws Exception {
		sysUserService.insertSysUser(syUserQueryVo.getSysUserCustom());
		// 默认为成功
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

	@RequestMapping("/deleteuser")
	public @ResponseBody
	SubmitResultInfo deleteuser(String id) throws Exception {
		sysUserService.deleteSysUser(id);
		// 默认为成功
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

}
