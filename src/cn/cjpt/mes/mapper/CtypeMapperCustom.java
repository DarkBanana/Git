package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.CtypeCustom;
import cn.cjpt.mes.pojo.vo.CtypeQueryVo;

/**
 * 柜体 包含 柜体编号。名字
 * 
 * @author yxf 2017年2月28日 下午8:46:15
 * 
 */
public interface CtypeMapperCustom {

	public List<CtypeCustom> findCtypeList(CtypeQueryVo ctypeQueryVO)
			throws Exception;

	public int findCtypeCount(CtypeQueryVo ctypeQueryVO) throws Exception;
}