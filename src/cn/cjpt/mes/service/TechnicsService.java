package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.Technics;
import cn.cjpt.mes.pojo.vo.TechnicsCustom;
import cn.cjpt.mes.pojo.vo.TechnicsQueryVo;

public interface TechnicsService {
	// 查询 工艺路线 列表
	public List<TechnicsCustom> findTechnicsList(TechnicsQueryVo technicsQueryVo)
			throws Exception;

	// 查询 工艺 （工位 ） 生产计划
	public List<TechnicsCustom> findTechnicsProductionPlan() throws Exception;

	// 根据 tcname 查询 Technics
	public Technics findTechnicsByTcname(String tcname) throws Exception;

	// 根据 部件名称，查询工艺路线
	public Technics findTechnicsByUnitName(String unitName) throws Exception;
}
