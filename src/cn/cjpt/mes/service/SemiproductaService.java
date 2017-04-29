package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.vo.SemiproductaCustom;
import cn.cjpt.mes.pojo.vo.SemiproductaQueryVo;

public interface SemiproductaService {

	int findSemiproductaCount(SemiproductaQueryVo semiproductaQueryVo) throws Exception;

	List<SemiproductaCustom> findSemiproductaList(SemiproductaQueryVo semiproductaQueryVo) throws Exception;

	void insertSemiproduct(String name, String ctypeid, String materielcoding) throws Exception;

	void outSemiproduct(String name, String outstorenum, String ctypeid, String remark1) throws Exception;

	// 查询 日期 最大的 记录
	public int findSemiproductaByMaxDate() throws Exception;
}
