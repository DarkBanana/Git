package cn.cjpt.mes.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.pojo.po.Equipmentledger;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.EquipmentledgerCustom;
import cn.cjpt.mes.pojo.vo.EquipmentledgerQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.EquipmentledgerService;

/**
 * 
 * @author qiaorenjie
 * 
 */

@Controller
@RequestMapping("/equipmentledger")
public class EquipmentledgerAction {

	@Autowired
	private EquipmentledgerService equipmentledgerService;

	/**
	 * 查询设备台账页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryequipmentledger")
	public String queryequipmentledger() throws Exception {

		return "/base/equipmentledger/queryequipmentledger";
	}

	/**
	 * 设备台账查询结果集 支持分页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryequipmentledger_result")
	public @ResponseBody
	DataGridResultInfo queryequipmentledger_result(
			EquipmentledgerQueryVo equipmentledgerQueryVo, int page,// 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		equipmentledgerQueryVo = equipmentledgerQueryVo != null ? equipmentledgerQueryVo
				: new EquipmentledgerQueryVo();

		// 查询列表的总数
		int total = equipmentledgerService
				.findEquipmentledgerCount(equipmentledgerQueryVo);
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);

		equipmentledgerQueryVo.setPageQuery(pageQuery);

		// 分页查询，向equipmentledgerQueryVo中传入pageQuery
		List<EquipmentledgerCustom> list = equipmentledgerService
				.findEquipmentledgerList(equipmentledgerQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	/**
	 * 修改设备台账信息 页面 数据显示
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editequipmentledger")
	@RequiresPermissions("equipmentledger:update")
	public String editequipmentledger(Model model, String id) throws Exception {
		// 通过id取出设备台账信息，传向页面
		EquipmentledgerCustom equipmentledgerCustom = equipmentledgerService
				.findEquipmentledgerById(id);
		// 将数据写到 model 中去
		model.addAttribute("equipmentledgerCustom", equipmentledgerCustom);

		return "/base/equipmentledger/editequipmentledger";
	}

	/**
	 * 修改设备台账信息 数据提交
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editequipmentledgersubmit")
	@RequiresPermissions("equipmentledger:update")
	public @ResponseBody
	SubmitResultInfo editequipmentledgersubmit(String id,
			EquipmentledgerQueryVo equipmentledgerQueryVo) throws Exception {
		// 调用 service 方法，更新数据
		this.equipmentledgerService.updateEquipmentledger(id,
				equipmentledgerQueryVo.getEquipmentledgerCustom());

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

	// 删除设备台账
	@RequestMapping("/deleteequipmentledger")
	@RequiresPermissions("equipmentledger:delete")
	public @ResponseBody
	SubmitResultInfo deleteequipmentledger(String id) throws Exception {

		// 调用service
		equipmentledgerService.deleteEquipmentledger(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, null));
	}

	/**
	 * 添加设备台账 页面显示
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addequipmentledger")
	@RequiresPermissions("equipmentledger:create")
	public String addequipmentledger() throws Exception {

		return "base/equipmentledger/addequipmentledger";
	}

	/**
	 * 添加设备台账 数据提交
	 * 
	 * @param equipmentledgerQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addequipmentledgersubmit")
	@RequiresPermissions("equipmentledger:create")
	public @ResponseBody
	SubmitResultInfo addequipmentledgersubmit(
			EquipmentledgerQueryVo equipmentledgerQueryVo) throws Exception {
		EquipmentledgerCustom custom = equipmentledgerQueryVo
				.getEquipmentledgerCustom();
		if (custom.getId().equals("") | custom.getToolname().equals("")
				| custom.getSpecifications().equals("")
				| custom.getToolnumber().equals("")) {
			return ResultUtil.createSubmitResult(ResultUtil.createFail(
					Config.MESSAGE, 236, null));
		} else {
			equipmentledgerService.insertEquipmentledger(equipmentledgerQueryVo
					.getEquipmentledgerCustom());
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, null));
		}

	}
}
