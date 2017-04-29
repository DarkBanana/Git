package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.SemiproductbCustom;
import cn.cjpt.mes.pojo.vo.SemiproductbQueryVo;

/**
 * 
 * 
 */
public interface SemiproductbCustomMapper {
	// 查询
	public List<SemiproductbCustom> findSemiproductbList(
			SemiproductbQueryVo SemiproductbQueryVo) throws Exception;

	// 查询总条数
	public int findSemiproductbCount(SemiproductbQueryVo SemiproductbQueryVo)
			throws Exception;

	// 查询到规格型号相同的最靠前的日期的
	public List<SemiproductbCustom> findSemiproductbByDate(
			SemiproductbQueryVo SemiproductbQueryVo) throws Exception;

	// 查询 最大 日期的 记录
	public SemiproductbCustom findSemiproductbByMaxDate() throws Exception;
}
