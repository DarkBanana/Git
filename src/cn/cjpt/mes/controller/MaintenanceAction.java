package cn.cjpt.mes.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.mapper.EquipmentledgerMapper;
import cn.cjpt.mes.mapper.MaintenanceMapper;
import cn.cjpt.mes.pojo.po.Equipmentledger;
import cn.cjpt.mes.pojo.po.EquipmentledgerExample;
import cn.cjpt.mes.pojo.po.EquipmentledgerExample.Criteria;
import cn.cjpt.mes.pojo.po.Maintenance;
import cn.cjpt.mes.pojo.po.MaintenanceExample;
import cn.cjpt.mes.pojo.vo.ActiveUser;
import cn.cjpt.mes.pojo.vo.EquipmentledgerCustom;
import cn.cjpt.mes.pojo.vo.MaintenanceCustom;
import cn.cjpt.mes.pojo.vo.MaintenanceQueryVo;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.EquipmentledgerService;
import cn.cjpt.mes.service.MaintenanceService;

/**
 * 
 * @author qiaorenjie
 * 
 */

@Controller
@RequestMapping("/maintenance")
public class MaintenanceAction {

	@Autowired
	private MaintenanceService maintenanceService;

	@Autowired
	private EquipmentledgerMapper equipmentledgerMapper;

	/**
	 * 查询用户页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querymaintenance")
	public String querymaintenance() throws Exception {

		return "/base/maintenance/querymaintenance";
	}

	/**
	 * 用户查询结果集 支持分页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querymaintenance_result")
	public @ResponseBody DataGridResultInfo querymaintenance_result(MaintenanceQueryVo maintenanceQueryVo, int page, // 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		maintenanceQueryVo = maintenanceQueryVo != null ? maintenanceQueryVo : new MaintenanceQueryVo();

		// 查询列表的总数
		int total = maintenanceService.findMaintenanceCount(maintenanceQueryVo);
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);

		maintenanceQueryVo.setPageQuery(pageQuery);

		maintenanceQueryVo.setPageQuery(pageQuery);

		// 分页查询，向maintenanceQueryVo中传入pageQuery
		List<MaintenanceCustom> list = maintenanceService.findMaintenanceList(maintenanceQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	/**
	 * 修改用户信息 页面 数据显示
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editmaintenance")
	@RequiresPermissions("maintenance:update")
	public String editmaintenance(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		MaintenanceCustom maintenanceCustom = maintenanceService.findMaintenanceById(id);
		// 将数据写到 model 中去
		model.addAttribute("maintenanceCustom", maintenanceCustom);

		EquipmentledgerExample example = new EquipmentledgerExample();
		Criteria criteria = example.createCriteria();
		List<Equipmentledger> equList = equipmentledgerMapper.selectByExample(example);
		model.addAttribute("equList", equList);

		return "/base/maintenance/editmaintenance";
	}

	/**
	 * 修改用户信息 数据提交
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editmaintenancesubmit")
	@RequiresPermissions("maintenance:delete")
	public @ResponseBody SubmitResultInfo editmaintenancesubmit(String id, MaintenanceQueryVo maintenanceQueryVo)
			throws Exception {
		// 判断 必填的未填则直接返回错误显示
		MaintenanceCustom custom = maintenanceQueryVo.getMaintenanceCustom();
		if (custom.getToolname().equals("") | custom.getSpecifications().equals("")) {
			return ResultUtil.createSubmitResult(ResultUtil.createFail(Config.MESSAGE, 282, null));
		}

		// 调用 service 方法，更新数据
		this.maintenanceService.updateMaintenance(id, maintenanceQueryVo.getMaintenanceCustom());

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, new Object[] {}));
	}

	// 删除用户
	@RequestMapping("/deletemaintenance")
	@RequiresPermissions("maintenance:delete")
	public @ResponseBody SubmitResultInfo deletemaintenance(String id) throws Exception {

		// 调用service
		maintenanceService.deleteMaintenance(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
	}

	/**
	 * 添加用户 页面显示
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addmaintenance")
	@RequiresPermissions("maintenance:create")
	public String addmaintenance(Model model) throws Exception {
		EquipmentledgerExample example = new EquipmentledgerExample();
		Criteria criteria = example.createCriteria();
		List<Equipmentledger> equList = equipmentledgerMapper.selectByExample(example);
		model.addAttribute("equList", equList);

		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);

		return "base/maintenance/addmaintenance";
	}

	/**
	 * 添加用户 数据提交
	 * 
	 * @param maintenanceQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addmaintenancesubmit")
	@RequiresPermissions("maintenance:create")
	public @ResponseBody SubmitResultInfo addmaintenancesubmit(MaintenanceQueryVo maintenanceQueryVo) throws Exception {
		MaintenanceCustom custom = maintenanceQueryVo.getMaintenanceCustom();
		if (custom.getToolname().equals("") | custom.getSpecifications().equals("")) {
			return ResultUtil.createSubmitResult(ResultUtil.createFail(Config.MESSAGE, 237, null));
		} else {
			maintenanceService.insertMaintenance(maintenanceQueryVo.getMaintenanceCustom());
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
		}

	}

	// 查看
	@RequestMapping("/detailmaintenance")
	public String detailmaintenance(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		MaintenanceCustom maintenanceCustom = maintenanceService.findMaintenanceById(id);
		// 将数据写到 model 中去
		model.addAttribute("maintenanceCustom", maintenanceCustom);

		return "/base/maintenance/detailmaintenance";
	}

}
