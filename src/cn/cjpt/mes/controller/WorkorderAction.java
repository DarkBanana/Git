package cn.cjpt.mes.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.mapper.TechnicsMapper;
import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.po.TechnicsExample;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.pojo.vo.PublishworkorderCustom;
import cn.cjpt.mes.pojo.vo.PublishworkorderQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.WorkorderService;

import com.github.pagehelper.PageInfo;

/**
 * 工单查询
 * 
 * 
 */

@Controller
@RequestMapping("/workorder")
public class WorkorderAction {

	@Autowired
	private WorkorderService workorderService;
	@Autowired
	private TechnicsMapper technicsMapper;

	/**
	 * 工单查询
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryworkorder")
	public String queryworkorder(Model model) throws Exception {
		TechnicsExample example = new TechnicsExample();
		List<Technics> list = technicsMapper.selectByExample(example);
		model.addAttribute("list", list);
		return "/base/orders/queryworkorder";
	}

	/**
	 * 订单查询结果集 支持分页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryworkorder_result")
	public @ResponseBody
	DataGridResultInfo queryworkorder_result(
			PublishworkorderQueryVo publishworkorderQueryVo, int page,// 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		publishworkorderQueryVo = publishworkorderQueryVo != null ? publishworkorderQueryVo
				: new PublishworkorderQueryVo();

		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);

		publishworkorderQueryVo.setPageQuery(pageQuery);

		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<PublishworkorderCustom> list = workorderService
				.findPublishworkorderList(publishworkorderQueryVo);

		PageInfo<PublishworkorderCustom> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	// 删除工单
	@RequestMapping("/deleteworkorder")
	@RequiresPermissions("orders:delete")
	public @ResponseBody
	SubmitResultInfo deleteworkorder(String id) throws Exception {

		// 调用service
		workorderService.deleteworkorder(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, null));
	}

}
