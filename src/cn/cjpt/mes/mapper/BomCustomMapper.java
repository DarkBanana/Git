package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.BomCustom;
import cn.cjpt.mes.pojo.vo.BomQueryVo;
import cn.cjpt.mes.pojo.vo.OrdersQueryVo;

/**
 * 自定义的SysuserMapper，便于扩展 2017年2月16日 上午10:50:40
 * 
 * 
 */
public interface BomCustomMapper {
	// BOM查询
	public List<BomCustom> findBomList(BomQueryVo bomQueryVo) throws Exception;

	// 查询BOM总条数
	public int findBomCount(BomQueryVo bomQueryVo) throws Exception;
	
	// BOM查询出remark1最大的
	public List<BomCustom> findBomListMaxRemark1(BomQueryVo bomQueryVo) throws Exception;
	
	// 查询出ctypeid=1且生产方式不是外购的bom
	public List<BomCustom> findBom() throws Exception;

}
