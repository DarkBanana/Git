package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.OrderdecomposeCustom;
import cn.cjpt.mes.pojo.vo.OrderdecomposeQueryVo;

/**
 * 自定义的Mapper，便于扩展 2017年2月16日 上午10:50:40
 * 
 * 
 */
public interface OrderdecomposeCustomMapper {
	// 派工单查询
	public List<OrderdecomposeCustom> findOrderdecomposeList(
			OrderdecomposeQueryVo orderdecomposeQueryVo) throws Exception;

	// 查询派工单总条数
	public int findOrderdecomposeCount(
			OrderdecomposeQueryVo orderdecomposeQueryVo) throws Exception;

	// 查询
	public List<OrderdecomposeCustom> findOrderdecomposeAndMaterial(
			OrderdecomposeQueryVo orderdecomposeQueryVo) throws Exception;
}
