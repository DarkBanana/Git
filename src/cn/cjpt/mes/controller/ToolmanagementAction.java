package cn.cjpt.mes.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.ToolmanagementCustom;
import cn.cjpt.mes.pojo.vo.ToolmanagementQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.ToolmanagementService;

/**
 * 
 * @author qiaorenjie
 * 
 */

@Controller
@RequestMapping("/toolmanagement")
public class ToolmanagementAction {

	@Autowired
	private ToolmanagementService toolmanagementService;

	/**
	 * 查询用户页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querytoolmanagement")
	public String querytoolmanagement() throws Exception {

		return "/base/toolmanagement/querytoolmanagement";
	}

	/**
	 * 用户查询结果集 支持分页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querytoolmanagement_result")
	public @ResponseBody
	DataGridResultInfo querytoolmanagement_result(
			ToolmanagementQueryVo toolmanagementQueryVo, int page,// 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		toolmanagementQueryVo = toolmanagementQueryVo != null ? toolmanagementQueryVo
				: new ToolmanagementQueryVo();

		// 查询列表的总数
		int total = toolmanagementService
				.findToolmanagementCount(toolmanagementQueryVo);
		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);

		toolmanagementQueryVo.setPageQuery(pageQuery);

		// 分页查询，向toolmanagementQueryVo中传入pageQuery
		List<ToolmanagementCustom> list = toolmanagementService
				.findToolmanagementList(toolmanagementQueryVo);

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	/**
	 *  页面 数据显示
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edittoolmanagement")
	@RequiresPermissions("toolmanagement:update")
	public String edittoolmanagement(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		ToolmanagementCustom toolmanagementCustom = toolmanagementService
				.findToolmanagementById(id);
		// 将数据写到 model 中去
		model.addAttribute("toolmanagementCustom", toolmanagementCustom);

		return "/base/toolmanagement/edittoolmanagement";
	}

	/**
	 * 修改用户信息 数据提交
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edittoolmanagementsubmit")
	@RequiresPermissions("toolmanagement:update")
	public @ResponseBody
	SubmitResultInfo edittoolmanagementsubmit(String id,
			ToolmanagementQueryVo toolmanagementQueryVo) throws Exception {
		// 调用 service 方法，更新数据
		this.toolmanagementService.updateToolmanagement(id,
				toolmanagementQueryVo.getToolmanagementCustom());

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

	// 删除用户
	@RequestMapping("/deletetoolmanagement")
	@RequiresPermissions("toolmanagement:delete")
	public @ResponseBody
	SubmitResultInfo deletetoolmanagement(String id) throws Exception {

		// 调用service
		toolmanagementService.deleteToolmanagement(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, null));
	}

	/**
	 * 添加用户 页面显示
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addtoolmanagement")
	@RequiresPermissions("toolmanagement:create")
	public String addtoolmanagement() throws Exception {

		return "base/toolmanagement/addtoolmanagement";
	}

	/**
	 * 添加用户 数据提交
	 * 
	 * @param toolmanagementQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addtoolmanagementsubmit")
	@RequiresPermissions("toolmanagement:create")
	public @ResponseBody
	SubmitResultInfo addtoolmanagementsubmit(
			ToolmanagementQueryVo toolmanagementQueryVo) throws Exception {
		ToolmanagementCustom custom = toolmanagementQueryVo
				.getToolmanagementCustom();
		if (custom.getId().equals("") | custom.getToolname().equals("")
				| custom.getSpecifications().equals("")
				| custom.getToolnumber().equals("")) {
			return ResultUtil.createSubmitResult(ResultUtil.createFail(
					Config.MESSAGE, 236, null));
		} else {
			toolmanagementService.insertToolmanagement(toolmanagementQueryVo
					.getToolmanagementCustom());
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, null));
		}

	}
}
