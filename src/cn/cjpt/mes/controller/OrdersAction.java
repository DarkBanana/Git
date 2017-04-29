package cn.cjpt.mes.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.pojo.po.Ctype;
import cn.cjpt.mes.pojo.po.CtypeExample;
import cn.cjpt.mes.pojo.po.CtypeExample.Criteria;
import cn.cjpt.mes.pojo.vo.OrdersCustom;
import cn.cjpt.mes.pojo.vo.OrdersQueryVo;
import cn.cjpt.mes.pojo.vo.PageQuery;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.DataGridResultInfo;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.process.result.SubmitResultInfo;
import cn.cjpt.mes.service.OrdersService;

import com.github.pagehelper.PageInfo;

/**
 * 订单管理
 * 
 * 
 */

@Controller
@RequestMapping("/orders")
public class OrdersAction {

	@Autowired
	private OrdersService ordersService;
	@Autowired
	private CtypeMapper ctypeMapper;

	/**
	 * 查询订单页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryorders")
	public String queryorders() throws Exception {

		return "/base/orders/queryorders";
	}

	/**
	 * 订单查询结果集 支持分页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryorders_result")
	public @ResponseBody
	DataGridResultInfo queryorders_result(OrdersQueryVo ordersQueryVo,
			int page, // 页码
			int rows) throws Exception// 每页显示个数) throws Exception
	{
		// 非空校验
		ordersQueryVo = ordersQueryVo != null ? ordersQueryVo
				: new OrdersQueryVo();

		// 分页支持
		PageQuery pageQuery = new PageQuery(page, rows);

		ordersQueryVo.setPageQuery(pageQuery);

		// 分页查询，向sysuserQueryVo中传入pageQuery
		List<OrdersCustom> list = ordersService.findOrdersList(ordersQueryVo);

		PageInfo<OrdersCustom> pageInfo = new PageInfo<>(list);
		int total = (int) pageInfo.getTotal();
		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		// 填充 total
		dataGridResultInfo.setTotal(total);
		// 填充 rows
		dataGridResultInfo.setRows(list);

		return dataGridResultInfo;
	}

	// 添加订单信息
	@RequestMapping("/addorders")
	@RequiresPermissions("orders:create")
	public String addorders(Model model) throws Exception {
		CtypeExample example = new CtypeExample();
		Criteria criteria = example.createCriteria();
		List<Ctype> ctList = ctypeMapper.selectByExample(example);
		model.addAttribute("ctList", ctList);
		return "/base/orders/addorders";
	}

	// 添加提交
	@RequestMapping("/addorderssubmit")
	@RequiresPermissions("orders:create")
	public @ResponseBody
	SubmitResultInfo addorderssubmit(OrdersQueryVo ordersQueryVo)
			throws Exception {
		OrdersCustom custom = ordersQueryVo.getOrdersCustom();
		if (custom.getOrdernum().equals("")
				| custom.getCabinetnumber().equals("")
				| custom.getBegintime().equals("")
				| custom.getEndtime().equals("")
				| custom.getMaterieltype().equals("")| custom.getMaterieltype().equals("0")) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
			return null;

		} else {
			ordersService.insertOrders(ordersQueryVo.getOrdersCustom());
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, null));
		}

	}

	// 删除订单
	@RequestMapping("/deleteorders")
	@RequiresPermissions("orders:delete")
	public @ResponseBody
	SubmitResultInfo deleteorders(String id) throws Exception {

		// 调用service
		ordersService.deleteorders(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, null));
	}

	// 修改生产订单
	@RequestMapping("/editorders")
	@RequiresPermissions("orders:update")
	public String editorders(Model model, String id) throws Exception {
		// 通过id取出用户信息，传向页面
		OrdersCustom ordersCustom = ordersService.findOrdersById(id);
		// 将数据写到 model 中去
		model.addAttribute("ordersCustom", ordersCustom);

		// 获取到柜体型号名称
		CtypeExample example = new CtypeExample();
		String materieltype = ordersCustom.getMaterieltype();
		Criteria criteria = example.createCriteria();
		criteria.andCnumEqualTo(materieltype);
		List<Ctype> ctList2 = ctypeMapper.selectByExample(example);
		model.addAttribute("ctList2", ctList2.get(0));

		// 将柜体类型数据放到model中
		CtypeExample example2 = new CtypeExample();
		List<Ctype> ctList = ctypeMapper.selectByExample(example2);
		ArrayList<Ctype> arrayList = new ArrayList<Ctype>();
		for (Ctype ctype : ctList) {
			if (!ctype.getCname().equals(ctList2.get(0).getCname())) {
				arrayList.add(ctype);
			}

		}
		model.addAttribute("ctList", arrayList);
		return "/base/orders/editorders";
	}

	/**
	 * 修改订单提交
	 * 
	 * @param id
	 * @param bomQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editorderssubmit")
	@RequiresPermissions("orders:update")
	public @ResponseBody
	SubmitResultInfo editorderssubmit(String id, OrdersQueryVo ordersQueryVo)
			throws Exception {
		// 调用 service 方法，更新数据
		OrdersCustom custom = ordersQueryVo.getOrdersCustom();
		if (custom.getOrdernum().equals("")
				| custom.getCabinetnumber().equals("")
				| custom.getBegintime().equals("")
				| custom.getEndtime().equals("")
				| custom.getMaterieltype().equals("")) {
			// 必填的未填，则返回显示错误
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
					null));
			return null;
		} else {
			this.ordersService
					.updateOrders(id, ordersQueryVo.getOrdersCustom());
			return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
					Config.MESSAGE, 906, new Object[] {}));
		}

	}

	/**
	 * 订单分解
	 * 
	 * @param id
	 * @param ordersQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/decomposeorders")
	@RequiresPermissions("orders:update")
	public @ResponseBody
	SubmitResultInfo decomposeorders(String id) throws Exception {
		// 调用 service 方法，更新数据
		ordersService.decompose(id);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(
				Config.MESSAGE, 906, new Object[] {}));
	}
}
