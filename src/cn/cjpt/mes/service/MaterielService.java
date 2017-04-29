package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.Materiel;
import cn.cjpt.mes.pojo.vo.MaterielCustom;

/**
 * Bom
 * 
 * @author yxf 2017年2月28日 下午9:08:08
 * 
 */
public interface MaterielService {
	public List<Materiel> findMaterielByCtypeId(String ctypeid)
			throws Exception;

	public List<Materiel> findMaterielByNnitname(String unitname)
			throws Exception;

	// 计算 部件的 生产计划
	public List<MaterielCustom> getPartsPlan() throws Exception;
}
