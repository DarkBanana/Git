package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.vo.OrdersCustom;
import cn.cjpt.mes.pojo.vo.OrdersQueryVo;
import cn.cjpt.mes.pojo.vo.RawstockCustom;
import cn.cjpt.mes.pojo.vo.RawstockQueryVo;

public interface RawstockService {
	public List<RawstockCustom> findRawstockList(RawstockQueryVo rawstockQueryVo)
			throws Exception;

	public int findRawstockCount(RawstockQueryVo rawstockQueryVo)
			throws Exception;

	public void insertRawstock(RawstockCustom rawstockCustom) throws Exception;

	public void outRawstock(RawstockCustom rawstockCustom) throws Exception;

	// 查询 出 材料区中 总共的钢材 还有多少
	public int findSteelPlateCount() throws Exception;
}
