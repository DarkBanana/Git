package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.OrdersCustom;
import cn.cjpt.mes.pojo.vo.OrdersQueryVo;

/**
 * 自定义 订单 查询
 * 
 * @author yxf 2017年3月16日 下午3:38:26
 * 
 */
public interface OrdersCustomMapper {
	// 订单查询
	public List<OrdersCustom> findOrdersList(OrdersQueryVo ordersQueryVo)
			throws Exception;

	// 查询订单总条数
	public int findOrdersCount(OrdersQueryVo ordersQueryVo) throws Exception;
}
