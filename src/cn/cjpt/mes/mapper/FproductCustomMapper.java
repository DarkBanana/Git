package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.FproductCustom;
import cn.cjpt.mes.pojo.vo.FproductQueryVo;

/**
 * 
 * 
 */
public interface FproductCustomMapper {
	// 查询
	public List<FproductCustom> findFproductList(FproductQueryVo fproductQueryVo)
			throws Exception;

	// 查询总条数
	public int findFproductCount(FproductQueryVo fproductQueryVo)
			throws Exception;

	// 查询到规格型号相同的最靠前的日期的
	public List<FproductCustom> findFproductByDate(
			FproductQueryVo fproductQueryVo) throws Exception;

	// 查询 日期 最大 的数据
	public FproductCustom findMaxDate() throws Exception;

}
