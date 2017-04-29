package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.vo.SemiproductbCustom;
import cn.cjpt.mes.pojo.vo.SemiproductbQueryVo;

public interface SemiproductbService {

	int findSemiproductbCount(SemiproductbQueryVo semiproductbQueryVo)
			throws Exception;

	List<SemiproductbCustom> findSemiproductbList(
			SemiproductbQueryVo semiproductbQueryVo) throws Exception;

	public void insertSemiproduct(SemiproductbCustom semiproductbCustom)
			throws Exception;

	public void outSemiproduct(SemiproductbCustom semiproductbCustom)
			throws Exception;

	// 查询 最大 日期的 记录
	public int findSemiproductbByMaxDate() throws Exception;

}
