package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.vo.OrdersCustom;
import cn.cjpt.mes.pojo.vo.OrdersQueryVo;
import cn.cjpt.mes.pojo.vo.PublishworkorderCustom;
import cn.cjpt.mes.pojo.vo.PublishworkorderQueryVo;

/**
 * 工单
 * 
 * @author yxf 2017年3月17日 下午12:30:03
 * 
 */
public interface WorkorderService {
	public List<PublishworkorderCustom> findPublishworkorderList(
			PublishworkorderQueryVo publishworkorderQueryVo) throws Exception;

	public int findPublishworkorderCount(
			PublishworkorderQueryVo publishworkorderQueryVo) throws Exception;

	public void deleteworkorder(String id) throws Exception;

	// 查询工单 根据 日期
	public List<PublishworkorderCustom> finPublishworkorderListByDate(
			PublishworkorderQueryVo publishworkorderQueryVo) throws Exception;

	// 根据 日期 和 工艺 id 计算 工位 要加工的总数量
	public int findTechnicsCountByDateAndTechnicsId(
			PublishworkorderQueryVo publishworkorderQueryVo) throws Exception;

}
