package cn.cjpt.mes.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.cjpt.mes.mapper.CtypeMapper;
import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.OrderdecomposeMapper;
import cn.cjpt.mes.mapper.OrdersCustomMapper;
import cn.cjpt.mes.mapper.OrdersMapper;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.MaterielExample;
import cn.cjpt.mes.pojo.po.MaterielExample.Criteria;
import cn.cjpt.mes.pojo.po.Orderdecompose;
import cn.cjpt.mes.pojo.po.Orders;
import cn.cjpt.mes.pojo.po.OrdersExample;
import cn.cjpt.mes.pojo.vo.OrdersCustom;
import cn.cjpt.mes.pojo.vo.OrdersQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.OrdersService;
import cn.cjpt.mes.util.UUIDBuild;

/**
 * 订单
 * 
 * @author yxf 2017年3月16日 下午4:06:10
 * 
 */
@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersCustomMapper ordersCustomMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private MaterielMapper materielMapper;
	@Autowired
	private OrderdecomposeMapper orderdecomposeMapper;
	@Autowired
	private CtypeMapper ctypeMapper;

	public List<OrdersCustom> findOrdersList(OrdersQueryVo ordersQueryVo)
			throws Exception {
		// TODO Auto-generated method stub
		int page = ordersQueryVo.getPageQuery().getPage();
		int rows = ordersQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		List<OrdersCustom> findOrdersList = ordersCustomMapper
				.findOrdersList(ordersQueryVo);
		return findOrdersList;
	}

	@Override
	public int findOrdersCount(OrdersQueryVo ordersQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return ordersCustomMapper.findOrdersCount(ordersQueryVo);
	}

	@Override
	public void insertOrders(OrdersCustom ordersCustom) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 信息 合法性 校验
		// 1.订单编号不能 重复
		String ordernum = ordersCustom.getOrdernum();
		Orders list = this.findOrdersByOrdernum(ordernum);
		if (list != null) {
			// 订单编号重复
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 218,
					null));
		}
		// .. 其他合法性校验
		ordersCustom.setId((UUIDBuild.getUUID()));
		ordersMapper.insert(ordersCustom);
	}

	private Orders findOrdersByOrdernum(String ordernum) {
		OrdersExample example = new OrdersExample();
		cn.cjpt.mes.pojo.po.OrdersExample.Criteria criteria = example
				.createCriteria();
		criteria.andOrdernumEqualTo(ordernum);
		// 设置查询条件，根据materielname查询
		List<Orders> list = ordersMapper.selectByExample(example);
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 删除orders
	 */
	@Override
	public void deleteorders(String id) throws Exception {
		// TODO Auto-generated method stub
		Orders orders = ordersMapper.selectByPrimaryKey(id);
		if (orders == null) {
			// 订单不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 217,
					null));
		}
		ordersMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 修改订单
	 */
	@Override
	public OrdersCustom findOrdersById(String id) throws Exception {
		// TODO Auto-generated method stub
		// 从数据库查询订单
		Orders orders = ordersMapper.selectByPrimaryKey(id);
		if (orders == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 220,
					null));
		}
		OrdersCustom ordersCustom = new OrdersCustom();
		// 将sysuser中数据设置到sysuserCustom
		BeanUtils.copyProperties(orders, ordersCustom);
		return ordersCustom;
	}

	@Override
	public void updateOrders(String id, OrdersCustom ordersCustom)
			throws Exception {
		// TODO Auto-generated method stub
		// 从数据库查询订单信息
		Orders orders = ordersMapper.selectByPrimaryKey(id);

		// 如果修改了订单编号，则编号不能重复
		if (!ordersCustom.getOrdernum().equals(orders.getOrdernum())) {
			// 修改后的Materielname不能重复
			Orders orders2 = this.findOrdersByOrdernum(ordersCustom
					.getOrdernum());
			if (orders2 != null) {
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						221, null));
			}
		}
		orders.setOrdernum(ordersCustom.getOrdernum());
		orders.setOrdercontract(ordersCustom.getOrdercontract());
		orders.setCabinetnumber(ordersCustom.getCabinetnumber());
		orders.setBegintime(ordersCustom.getBegintime());
		orders.setEndtime(ordersCustom.getEndtime());
		orders.setLoadcenter(ordersCustom.getLoadcenter());
		orders.setModeproduction(ordersCustom.getModeproduction());
		orders.setMaterieltype(ordersCustom.getMaterieltype());
		ordersMapper.updateByPrimaryKey(orders);
	}

	/**
	 * 订单分解
	 */
	@Override
	public void decompose(String id) throws Exception {
		// TODO Auto-generated method stub
		Orders orders = ordersMapper.selectByPrimaryKey(id);
		String materieltype = orders.getMaterieltype();
		MaterielExample example = new MaterielExample();
		Criteria criteria = example.createCriteria();
		// 拿到BOM表中的所有BOM结构
		List<Materiel> list = materielMapper.selectByExample(example);
		if (orders.getRemark() == null || orders.getRemark().equals("")
				|| orders.getRemark().equals("未分解")) {
			int cabinetnumber = Integer.parseInt(orders.getCabinetnumber());
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					// 当bom表中元素的制造方法为自产时执行
					if (!list.get(i).getMaterielmethod().equals("外购")
							&& !list.get(i).getMaterielmethod().equals("0")
							&& ctypeMapper
									.selectByPrimaryKey(
											list.get(i).getCtypeid()).getCnum()
									.equals(materieltype)
							&& list.get(i).getMaterielmark().equals("1")) {
						// 第一条生产线bom进行订单分解
						Orderdecompose orderdecompose = new Orderdecompose();
						orderdecompose.setId(UUIDBuild.getUUID());
						int materielnumber = Integer.parseInt(list.get(i)
								.getMaterielnumber());
						orderdecompose.setOdnumber("" + cabinetnumber
								* materielnumber);
						orderdecompose.setMaterielid(list.get(i).getId());
						orderdecompose.setOrdersid(orders.getId());
						orderdecomposeMapper.insert(orderdecompose);
					} else if (!list.get(i).getMaterielmethod().equals("外购")
							&& !list.get(i).getMaterielmethod().equals("0")
							&& ctypeMapper
									.selectByPrimaryKey(
											list.get(i).getCtypeid()).getCnum()
									.equals(materieltype)
							&& list.get(i).getMaterielmark().equals("2")) {
						// 第二条生产线，机装、电装、总装工序进行订单分解
						Orderdecompose orderdecompose2 = new Orderdecompose();
						orderdecompose2.setId(UUIDBuild.getUUID());
						int materielnumber = Integer.parseInt(list.get(i)
								.getMaterielnumber());
						orderdecompose2.setOdnumber("" + cabinetnumber
								* materielnumber);
						orderdecompose2.setMaterielid(list.get(i).getId());
						orderdecompose2.setOrdersid(orders.getId());
						orderdecomposeMapper.insert(orderdecompose2);
					} else {
					}
				}
				orders.setRemark("1");
				ordersMapper.updateByPrimaryKey(orders);
			} else {
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
						223, null));
			}
		} else {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 224,
					null));
		}

	}
}
