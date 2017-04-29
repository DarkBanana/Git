package cn.cjpt.mes.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.OrdersMapper;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.Orders;
import cn.cjpt.mes.pojo.vo.OrderdecomposeCustom;
import cn.cjpt.mes.pojo.vo.OrderdecomposeQueryVo;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.OrderdecomposeService;

import com.github.pagehelper.PageInfo;

/**
 * 派订单管理
 * 
 * 
 */

@Controller
@RequestMapping("/decomposeorders")
public class OrderdecomposeAction {

	@Autowired
	private OrderdecomposeService orderdecomposeService;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private MaterielMapper materielMapper;
	@Autowired
	private CtypeMapper ctypeMapper;

	/**
	 * 查询派工单页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querydecomposeorders")
	public String queryorders() throws Exception {

		return "/base/orders/querydecomposeorders";
	}

	/**
	 * 订单查询结果集 支持分页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querydecomposeorders_result")
	public @ResponseBody
	DataGridResultInfo querydecomposeorders_result(
			OrderdecomposeQueryVo orderdecomposeQueryVo, int page,// 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		orderdecomposeQueryVo = orderdecomposeQueryVo != null ? orderdecomposeQueryVo
				: new OrderdecomposeQueryVo();

		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);
		orderdecomposeQueryVo.setPageQuery(pageQuery);

		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<OrderdecomposeCustom> list = orderdecomposeService
				.findOrderdecomposeList(orderdecomposeQueryVo);

		PageInfo<OrderdecomposeCustom> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();

		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	// 删除派工单
	@RequestMapping("/deletedecomposeorders")
	@RequiresPermissions("orders:delete")
	public @ResponseBody
	SubmitResultInfo deletedecomposeorders(String id) throws Exception {

		// 调用service
		orderdecomposeService.deletedecomposeorders(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, null));
	}

	// 修改派工单
	@RequestMapping("/editorderdecompose")
	@RequiresPermissions("orders:update")
	public String editorderdecompose(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		OrderdecomposeCustom orderdecomposeCustom = orderdecomposeService
				.findOrderdecomposeById(id);
		// 将数据写到 model 中去
		model.addAttribute("orderdecomposeCustom", orderdecomposeCustom);
		String ordersid = orderdecomposeCustom.getOrdersid();
		Orders orders = ordersMapper.selectByPrimaryKey(ordersid);
		// 拿到订单编号
		String ordernum = orders.getOrdernum();
		model.addAttribute("ordernum", ordernum);
		// 拿到名称
		String materielid = orderdecomposeCustom.getMaterielid();
		Materiel materiel = materielMapper.selectByPrimaryKey(materielid);
		String unitname = materiel.getUnitname();
		model.addAttribute("unitname", unitname);
		// 拿到柜体类型
		String ctypeid = materiel.getCtypeid();
		Ctype ctype = ctypeMapper.selectByPrimaryKey(ctypeid);
		String cname = ctype.getCname();
		model.addAttribute("cname", cname);
		return "/base/orders/editdecomposeorders";
	}

	// 修改派工单提交
	@RequestMapping("/editorderdecomposesubmit")
	@RequiresPermissions("orders:update")
	public @ResponseBody
	SubmitResultInfo editorderdecomposesubmit(String id,
			OrderdecomposeQueryVo orderdecomposeQueryVo) throws Exception {
		// 调用 service 方法，更新数据
		this.orderdecomposeService.updateOrderdecompose(id,
				orderdecomposeQueryVo.getOrderdecomposeCustom());

		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}

	/**
	 * 派工单发布
	 */
	@RequestMapping("/publishworkorder")
	@RequiresPermissions("orders:update")
	public @ResponseBody
	SubmitResultInfo publishworkorder(String id) throws Exception {
		// 调用 service 方法，更新数据
		orderdecomposeService.publish(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}
}
