package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.po.Publishworkorder;
import cn.cjpt.mes.pojo.vo.OrdersCustom;
import cn.cjpt.mes.pojo.vo.PublishworkorderCustom;
import cn.cjpt.mes.pojo.vo.PublishworkorderQueryVo;

/**
 * 派工单
 * 
 * 
 */
public interface PublishworkorderCustomMapper {
	// 工单查询
	public List<PublishworkorderCustom> findPublishworkorderList(
			PublishworkorderQueryVo publishworkorderQueryVo) throws Exception;

	// 查询工单总条数
	public int findPublishworkorderCount(
			PublishworkorderQueryVo publishworkorderQueryVo) throws Exception;

	// 查询工单 根据 日期
	public List<PublishworkorderCustom> finPublishworkorderListByDate(
			PublishworkorderQueryVo publishworkorderQueryVoe) throws Exception;
}
