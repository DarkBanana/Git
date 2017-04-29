package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.vo.RawstocktypeCustom;
import cn.cjpt.mes.pojo.vo.RawstocktypeQueryVo;

public interface RawstocktypeService {

	public int findRawstocktypeCount(RawstocktypeQueryVo rawstocktypeQueryVo)
			throws Exception;

	public List<RawstocktypeCustom> findRawstocktypeList(
			RawstocktypeQueryVo rawstocktypeQueryVo) throws Exception;

	public void insertRawstock(RawstocktypeCustom rawstocktypeCustom)
			throws Exception;

	public void deleterawstocktype(String id) throws Exception;

	public RawstocktypeCustom findrawstocktypeById(String id) throws Exception;

	public void updateRawstocktype(String id,
			RawstocktypeCustom rawstocktypeCustom) throws Exception;

	// 查询 钢板 种类
	public List<RawstocktypeCustom> findSteelPlateType() throws Exception;

}
