package cn.cjpt.mes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cjpt.mes.mapper.OrderdecomposeMapper;
import cn.cjpt.mes.mapper.PublishworkorderCustomMapper;
import cn.cjpt.mes.mapper.PublishworkorderMapper;
import cn.cjpt.mes.pojo.po.Orderdecompose;
import cn.cjpt.mes.pojo.po.Publishworkorder;
import cn.cjpt.mes.pojo.vo.PublishworkorderCustom;
import cn.cjpt.mes.pojo.vo.PublishworkorderQueryVo;
import cn.cjpt.mes.process.context.Config;
import cn.cjpt.mes.process.result.ResultUtil;
import cn.cjpt.mes.service.WorkorderService;

import com.github.pagehelper.PageHelper;

@Service
public class WorkorderServiceImpl implements WorkorderService {
	@Autowired
	private PublishworkorderCustomMapper publishworkorderCustomMapper;
	@Autowired
	private PublishworkorderMapper publishworkorderMapper;
	@Autowired
	private OrderdecomposeMapper orderdecomposeMapper;

	@Override
	public List<PublishworkorderCustom> findPublishworkorderList(
			PublishworkorderQueryVo publishworkorderQueryVo) throws Exception {

		int page = publishworkorderQueryVo.getPageQuery().getPage();
		int rows = publishworkorderQueryVo.getPageQuery().getRows();
		// 再 执行 sql 代码前面 加入 PageHelper。并给PageHelper设置 page 和 rows
		PageHelper.startPage(page, rows);

		return publishworkorderCustomMapper
				.findPublishworkorderList(publishworkorderQueryVo);
	}

	@Override
	public int findPublishworkorderCount(
			PublishworkorderQueryVo publishworkorderQueryVo) throws Exception {
		int count = publishworkorderCustomMapper
				.findPublishworkorderCount(publishworkorderQueryVo);
		return publishworkorderCustomMapper
				.findPublishworkorderCount(publishworkorderQueryVo);
	}

	@Override
	public void deleteworkorder(String id) throws Exception {
		// TODO Auto-generated method stub
		Publishworkorder publishworkorder = publishworkorderMapper
				.selectByPrimaryKey(id);
		if (publishworkorder == null) {
			// 工单不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 228,
					null));
		}
		publishworkorderMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据 日期 查询 工单 信息
	 */
	@Override
	public List<PublishworkorderCustom> finPublishworkorderListByDate(
			PublishworkorderQueryVo publishworkorderQueryVo) throws Exception {

		List<PublishworkorderCustom> list = publishworkorderCustomMapper
				.finPublishworkorderListByDate(publishworkorderQueryVo);

		if (list.size() == 0) {
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 228,
					null));
		}
		return list;
	}

	/**
	 * 根据 时间 和 工艺 id 查找工位 要加工的 数量 订单要是已发布的订单
	 */
	@Override
	public int findTechnicsCountByDateAndTechnicsId(
			PublishworkorderQueryVo publishworkorderQueryVo) throws Exception {

		int count = 0;
		// System.out.println(publishworkorderQueryVo.getNowTime());
		// 查询 到的 工单
		List<PublishworkorderCustom> list = publishworkorderCustomMapper
				.finPublishworkorderListByDate(publishworkorderQueryVo);

		List<PublishworkorderCustom> list2 = new ArrayList<>();
		// 判断 订单是否 发布
		for (PublishworkorderCustom publishworkorderCustom : list) {
			String orderdecomposeid = publishworkorderCustom
					.getOrderdecomposeid();
			Orderdecompose orderdecompose = orderdecomposeMapper
					.selectByPrimaryKey(orderdecomposeid);
			if (orderdecompose != null) {
				
				System.out.println("orderdecompose Remark"
						+ orderdecompose.getRemark());
				
				if (orderdecompose.getRemark().equals("已发布")) {
					list2.add(publishworkorderCustom);
				}
			}
		}

		System.out.println("===已发布的订单：已发===" + list2.size());
		// 如果 为空，抛出异常
		if (list2.size() != 0) {
			for (PublishworkorderCustom publishworkorderCustom : list) {
				count += Integer
						.parseInt(publishworkorderCustom.getPwonumber());
			}
		}
		return count;
	}
}
