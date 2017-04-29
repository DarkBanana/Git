package cn.cjpt.mes.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.cjpt.mes.mapper.MaterielMapper;
import cn.cjpt.mes.mapper.OrderdecomposeCustomMapper;
import cn.cjpt.mes.mapper.OrderdecomposeMapper;
import cn.cjpt.mes.mapper.OrdersMapper;
import cn.cjpt.mes.mapper.PublishworkorderMapper;
import cn.cjpt.mes.mapper.TechnicsMapper;
import cn.cjpt.mes.mapper.TodayplanMapper;
import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.po.Orderdecompose;
import cn.cjpt.mes.pojo.po.Orders;
import cn.cjpt.mes.pojo.po.Publishworkorder;
import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.po.TechnicsExample;
import cn.cjpt.mes.pojo.po.Todayplan;
import cn.cjpt.mes.pojo.po.TodayplanExample;
import cn.cjpt.mes.pojo.vo.OrderdecomposeCustom;
import cn.cjpt.mes.pojo.vo.OrderdecomposeQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.OrderdecomposeService;
import cn.cjpt.mes.util.IDUtils;
import cn.cjpt.mes.util.UUIDBuild;

import com.github.pagehelper.PageHelper;

public class OrderdecomposeServiceImpl implements OrderdecomposeService {
	@Autowired
	private OrderdecomposeCustomMapper orderdecomposeCustomMapper;
	@Autowired
	private TechnicsMapper technicsMapper;
	@Autowired
	private OrderdecomposeMapper orderdecomposeMapper;
	@Autowired
	private PublishworkorderMapper publishworkorderMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private MaterielMapper materielMapper;
	@Autowired
	private TodayplanMapper tpm;

	// 拿到所有的订单分解的数据
	@Override
	public List<OrderdecomposeCustom> findOrderdecomposeList(
			OrderdecomposeQueryVo orderdecomposeQueryVo) throws Exception {
		// TODO Auto-generated method stub

		int page = orderdecomposeQueryVo.getPageQuery().getPage();
		int rows = orderdecomposeQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		return orderdecomposeCustomMapper
				.findOrderdecomposeList(orderdecomposeQueryVo);
	}

	// 拿到订单分解的总条数
	@Override
	public int findOrderdecomposeCount(
			OrderdecomposeQueryVo orderdecomposeQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return orderdecomposeCustomMapper
				.findOrderdecomposeCount(orderdecomposeQueryVo);
	}

	@Override
	public void deletedecomposeorders(String id) throws Exception {
		// TODO Auto-generated method stub
		Orderdecompose orderdecompose = orderdecomposeMapper
				.selectByPrimaryKey(id);
		if (orderdecompose == null) {
			// 派工单不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 225,
					null));
		}
		orderdecomposeMapper.deleteByPrimaryKey(id);
	}

	// 修改派工单查询
	@Override
	public OrderdecomposeCustom findOrderdecomposeById(String id)
			throws Exception {
		// TODO Auto-generated method stub
		Orderdecompose orderdecompose = orderdecomposeMapper
				.selectByPrimaryKey(id);
		if (orderdecompose == null) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 226,
					null));
		}
		OrderdecomposeCustom orderdecomposeCustom = new OrderdecomposeCustom();

		// 将sysuser中数据设置到sysuserCustom
		BeanUtils.copyProperties(orderdecompose, orderdecomposeCustom);
		return orderdecomposeCustom;
	}

	// 提交修改
	@Override
	public void updateOrderdecompose(String id,
			OrderdecomposeCustom orderdecomposeCustom) throws Exception {
		Orderdecompose orderdecompose2 = orderdecomposeMapper.selectByPrimaryKey(id);
		String ordersid = orderdecompose2.getOrdersid();
		Orders order = ordersMapper.selectByPrimaryKey(ordersid);
		String orderbegintime = order.getBegintime();
		String orderendtime = order.getEndtime();
		SimpleDateFormat sdf2 = new SimpleDateFormat();
		if (orderdecomposeCustom.getBegintime().compareTo(orderbegintime)>=0&&orderdecomposeCustom.getEndtime().compareTo(orderendtime)<=0) {
			// TODO Auto-generated method stub
			if (orderdecomposeCustom.getBegintime() != null
					&& !orderdecomposeCustom.getBegintime().equals("")
					&& orderdecomposeCustom.getEndtime() != null
					&& !orderdecomposeCustom.getEndtime().equals("")) {
				Orderdecompose orderdecompose = orderdecomposeMapper
						.selectByPrimaryKey(id);
				String materielid = orderdecompose.getMaterielid();
				Materiel mt = materielMapper.selectByPrimaryKey(materielid);
				String mtnum = mt.getTasktime();
				String odnum = orderdecompose.getOdnumber();
				int time = Integer.valueOf(mtnum) * Integer.valueOf(odnum);// 分钟
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date beginTime = sdf.parse(orderdecomposeCustom.getBegintime());
				Date endTime = sdf.parse(orderdecomposeCustom.getEndtime());
				int minTime = (int) ((endTime.getTime() - beginTime.getTime()) / (1000 * 60));
				if (minTime - time >= 0) {
					orderdecompose.setOdnumber(orderdecomposeCustom.getOdnumber());
					orderdecompose
							.setBegintime(orderdecomposeCustom.getBegintime());
					orderdecompose.setEndtime(orderdecomposeCustom.getEndtime());
					orderdecomposeMapper
							.updateByPrimaryKeySelective(orderdecompose);
				} else {
					ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
							280, null));
				}
			} else {
				ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 921,
						null));
			}
		}else {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE,
					320, null));
		}
		

	}

	/**
	 * 发布派工单操作
	 */
	@Override
	public void publish(String id) throws Exception {
		// TODO Auto-generated method stub
		Orderdecompose orderdecompose = orderdecomposeMapper
				.selectByPrimaryKey(id);
		TechnicsExample example = new TechnicsExample();
		cn.cjpt.mes.pojo.po.TechnicsExample.Criteria criteria = example
				.createCriteria();
		List<Technics> list = technicsMapper.selectByExample(example);
		if (orderdecompose.getBegintime() != null
				&& orderdecompose.getEndtime() != null) {
			if (orderdecompose.getId() != null) {
				if (list.size() > 0 && list != null) {
					for (int i = 0; i < list.size(); i++) {
						// 当为第一种工艺时
						if (list.get(i).getTechnicsmark().equals("1")
								&& !materielMapper
										.selectByPrimaryKey(
												orderdecompose.getMaterielid())
										.getMaterielmark().equals("2")
								&& orderdecompose.getRemark() == null) {
							Publishworkorder pwo = new Publishworkorder();
							pwo.setTechnicsid(list.get(i).getId());
							pwo.setOrderdecomposeid(orderdecompose.getId());
							pwo.setBegintime(orderdecompose.getBegintime());
							pwo.setEndtime(orderdecompose.getEndtime());
							pwo.setPwonumber(orderdecompose.getOdnumber());
							pwo.setPublishworkordenum(IDUtils.genItemId() + "");
							pwo.setId(UUIDBuild.getUUID());
							publishworkorderMapper.insert(pwo);

						} else if (list.get(i).getTechnicsmark().equals("1")
								&& !materielMapper
										.selectByPrimaryKey(
												orderdecompose.getMaterielid())
										.getMaterielmark().equals("2")
								&& !orderdecompose.getRemark().equals("1")
								&& !orderdecompose.getRemark().equals("已发布")) {
							Publishworkorder pwo = new Publishworkorder();
							pwo.setTechnicsid(list.get(i).getId());
							pwo.setOrderdecomposeid(orderdecompose.getId());
							pwo.setBegintime(orderdecompose.getBegintime());
							pwo.setEndtime(orderdecompose.getEndtime());
							pwo.setPwonumber(orderdecompose.getOdnumber());
							pwo.setPublishworkordenum(IDUtils.genItemId() + "");
							pwo.setId(UUIDBuild.getUUID());
							publishworkorderMapper.insert(pwo);
						} else if (list.get(i).getTechnicsmark().equals("2")
								&& materielMapper
										.selectByPrimaryKey(
												orderdecompose.getMaterielid())
										.getUnitname()
										.equals(list.get(i).getTcname())
								&& orderdecompose.getRemark() == null) {
							Publishworkorder pwo = new Publishworkorder();
							pwo.setTechnicsid(list.get(i).getId());
							pwo.setOrderdecomposeid(orderdecompose.getId());
							pwo.setBegintime(orderdecompose.getBegintime());
							pwo.setEndtime(orderdecompose.getEndtime());
							pwo.setPwonumber(orderdecompose.getOdnumber());
							pwo.setPublishworkordenum(IDUtils.genItemId() + "");
							pwo.setId(UUIDBuild.getUUID());
							publishworkorderMapper.insert(pwo);
						} else if (list.get(i).getTechnicsmark().equals("2")
								&& materielMapper
										.selectByPrimaryKey(
												orderdecompose.getMaterielid())
										.getUnitname()
										.equals(list.get(i).getTcname())
								&& !orderdecompose.getRemark().equals("1")
								&& !orderdecompose.getRemark().equals("已发布")) {
							Publishworkorder pwo = new Publishworkorder();
							pwo.setTechnicsid(list.get(i).getId());
							pwo.setOrderdecomposeid(orderdecompose.getId());
							pwo.setBegintime(orderdecompose.getBegintime());
							pwo.setEndtime(orderdecompose.getEndtime());
							pwo.setPwonumber(orderdecompose.getOdnumber());
							pwo.setPublishworkordenum(IDUtils.genItemId() + "");
							pwo.setId(UUIDBuild.getUUID());
							publishworkorderMapper.insert(pwo);
						}
					}
					// 今日计划书
					Todayplan todayplan = new Todayplan();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String begintime = orderdecompose.getBegintime().substring(
							0, 10);
					String endtime = orderdecompose.getEndtime().substring(0,
							10);
					Date btime = sdf.parse(begintime);
					Date etime = sdf.parse(endtime);
					Calendar cal = Calendar.getInstance();
					cal.setTime(btime);
					long time1 = cal.getTimeInMillis();
					cal.setTime(etime);
					long time2 = cal.getTimeInMillis();
					// 拿到时间差，计算时注意加一，算头算尾！
					long between_days = (time2 - time1) / (1000 * 3600 * 24);
					System.out.println(between_days);
					Date time = null;
					boolean flag = true;
					for (int j = 0; j < between_days + 1; j++) {
						// 设置ID
						todayplan.setId(UUIDBuild.getUUID());
						// 设置部件名称
						String materielid = orderdecompose.getMaterielid();
						Materiel materiel = materielMapper
								.selectByPrimaryKey(materielid);
						todayplan.setName(materiel.getUnitname());
						// 设置部件编码
						todayplan.setCode(materiel.getUnitcode());
						// 设置计算数量
						int totalnum = Integer.parseInt(orderdecompose
								.getOdnumber());
						// 已完成数量
						// 1.拿到所属订单以及名称
						String ordersid = orderdecompose.getOrdersid();
						TodayplanExample todayplanExample = new TodayplanExample();
						cn.cjpt.mes.pojo.po.TodayplanExample.Criteria tpcriteria = todayplanExample
								.createCriteria();
						tpcriteria.andNameEqualTo(materiel.getUnitname());
						tpcriteria.andOrdersidEqualTo(ordersid);
						List<Todayplan> tpclist = tpm
								.selectByExample(todayplanExample);
						// size是已经安排的个数
						int size = tpclist.size();
						// downnum是剩余天数
						int downtime = (int) between_days + 1 - size;
						// 统计已经完成的
						int downnum = 0;
						for (int k = 0; k < tpclist.size(); k++) {
							String num = tpclist.get(k).getNum();
							downnum += Integer.parseInt(num);
						}
						int todaynum = (int) Math
								.ceil((double) (totalnum - downnum)
										/ (double) downtime);
						todayplan.setNum(todaynum + "");
						// 设置生产线号
						todayplan.setLine(materiel.getMaterielmark());
						// 设置所属订单
						todayplan.setOrdersid(orderdecompose.getOrdersid());
						// 设置日期

						Calendar calendar = new GregorianCalendar();

						if (flag) {
							calendar.setTime(btime);
							flag = false;
						} else {
							calendar.setTime(time);
						}
						time = calendar.getTime();
						String formattime = sdf.format(time);
						todayplan.setTime(formattime);
						calendar.add(calendar.DATE, 1);
						time = calendar.getTime();
						tpm.insert(todayplan);
					}
				} else {
					ResultUtil.throwExcepion(ResultUtil.createFail(
							Config.MESSAGE, 227, null));
				}
				orderdecompose.setRemark("1");
				orderdecomposeMapper.updateByPrimaryKey(orderdecompose);

			}

		} else {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 281,
					null));
		}

	}

	/**
	 * 查询 订单分解和物料信息
	 */
	@Override
	public List<OrderdecomposeCustom> findOrderdecomposeAndMaterial(
			OrderdecomposeQueryVo orderdecomposeQueryVo) throws Exception {
		return orderdecomposeCustomMapper
				.findOrderdecomposeAndMaterial(orderdecomposeQueryVo);
	}

}
