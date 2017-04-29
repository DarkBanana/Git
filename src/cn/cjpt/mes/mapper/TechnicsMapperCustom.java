package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.TechnicsCustom;
import cn.cjpt.mes.pojo.vo.TechnicsQueryVo;

/**
 * 工艺路线
 * 
 * @author yxf 2017年3月17日 下午2:20:22
 * 
 */
public interface TechnicsMapperCustom {

	// 查询 工艺路线 列表
	public List<TechnicsCustom> findTechnicsList(TechnicsQueryVo technicsQueryVo)
			throws Exception;
}
