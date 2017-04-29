package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.FproductCustom;
import cn.cjpt.mes.pojo.vo.OrdersCustom;
import cn.cjpt.mes.pojo.vo.OrdersQueryVo;
import cn.cjpt.mes.pojo.vo.RawstockCustom;
import cn.cjpt.mes.pojo.vo.RawstockQueryVo;

/**
 * 自定义的SysuserMapper，便于扩展 2017年2月16日 上午10:50:40
 * 
 * 
 */
public interface RawstockCustomMapper {
	// 物料查询
	public List<RawstockCustom> findRawstockList(RawstockQueryVo rawstockQueryVo)
			throws Exception;

	// 查询物料总条数
	public int findRawstockCount(RawstockQueryVo rawstockQueryVo)
			throws Exception;

	// 查询到规格型号相同的最靠前的日期的物料
	public List<RawstockCustom> findRawstockByDate(
			RawstockQueryVo rawstockQueryVo) throws Exception;

	// 查询 日期 最大 的数据
	public RawstockCustom findMaxDate() throws Exception;
}
