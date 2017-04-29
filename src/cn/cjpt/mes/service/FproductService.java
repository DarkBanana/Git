package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.vo.FproductCustom;
import cn.cjpt.mes.pojo.vo.FproductQueryVo;

public interface FproductService {

	int findFproductCount(FproductQueryVo fproductQueryVo) throws Exception;

	List<FproductCustom> findFproductList(FproductQueryVo fproductQueryVo)
			throws Exception;

	void insertFproduct(String ctypeid, String string) throws Exception;

	public void outFproduct(FproductCustom fproductCustom) throws Exception;

	// 查询 日期最大的数据
	public FproductCustom findMaxDate() throws Exception;
}
