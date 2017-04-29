package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.vo.OrdersCustom;
import cn.cjpt.mes.pojo.vo.OrdersQueryVo;

public interface OrdersService {
	public List<OrdersCustom> findOrdersList(OrdersQueryVo ordersQueryVo)
			throws Exception;

	public int findOrdersCount(OrdersQueryVo ordersQueryVo) throws Exception;

	public void insertOrders(OrdersCustom ordersCustom) throws Exception;

	public void deleteorders(String id) throws Exception;

	public OrdersCustom findOrdersById(String id) throws Exception;

	public void updateOrders(String id, OrdersCustom ordersCustom)
			throws Exception;

	public void decompose(String id) throws Exception;

}
