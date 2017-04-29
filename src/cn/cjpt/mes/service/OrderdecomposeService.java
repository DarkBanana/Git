package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.vo.OrderdecomposeCustom;
import cn.cjpt.mes.pojo.vo.OrderdecomposeQueryVo;

public interface OrderdecomposeService {
	public List<OrderdecomposeCustom> findOrderdecomposeList(
			OrderdecomposeQueryVo orderdecomposeQueryVo) throws Exception;

	public int findOrderdecomposeCount(
			OrderdecomposeQueryVo orderdecomposeQueryVo) throws Exception;

	public void deletedecomposeorders(String id) throws Exception;

	public OrderdecomposeCustom findOrderdecomposeById(String id)
			throws Exception;

	public void updateOrderdecompose(String id,
			OrderdecomposeCustom orderdecomposeCustom) throws Exception;

	public void publish(String id) throws Exception;

	// 查询 订单分解和 物料信息
	public List<OrderdecomposeCustom> findOrderdecomposeAndMaterial(
			OrderdecomposeQueryVo orderdecomposeQueryVo) throws Exception;
}
