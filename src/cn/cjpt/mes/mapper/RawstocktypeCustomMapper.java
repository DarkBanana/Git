package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.OrdersCustom;
import cn.cjpt.mes.pojo.vo.OrdersQueryVo;
import cn.cjpt.mes.pojo.vo.RawstockCustom;
import cn.cjpt.mes.pojo.vo.RawstockQueryVo;
import cn.cjpt.mes.pojo.vo.RawstocktypeCustom;
import cn.cjpt.mes.pojo.vo.RawstocktypeQueryVo;

/**
 * 
 * 
 */
public interface RawstocktypeCustomMapper {
	// 物料类型查询
	public List<RawstocktypeCustom> findRawstocktypeList(
			RawstocktypeQueryVo rawstocktypeQueryVo) throws Exception;

	// 查询物料类型总条数
	public int findRawstocktypeCount(RawstocktypeQueryVo rawstocktypeQueryVo)
			throws Exception;
}
