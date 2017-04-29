package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.SemiproductaCustom;
import cn.cjpt.mes.pojo.vo.SemiproductaQueryVo;

/**
 * 
 * 
 */
public interface SemiproductaCustomMapper {
	// 查询
	public List<SemiproductaCustom> findSemiproductaList(
			SemiproductaQueryVo semiproductaQueryVo) throws Exception;

	// 查询总条数
	public int findSemiproductaCount(SemiproductaQueryVo semiproductaQueryVo)
			throws Exception;

	// 查询到规格型号相同的最靠前的日期的
	public List<SemiproductaCustom> findSemiproductaByDate(
			SemiproductaQueryVo semiproductaQueryVo) throws Exception;

	// 查询 日期 最大的 记录
	public SemiproductaCustom findSemiproductaByMaxDate() throws Exception;
}
