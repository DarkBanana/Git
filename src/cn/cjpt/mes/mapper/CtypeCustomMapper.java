package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.CtypeCustom;
import cn.cjpt.mes.pojo.vo.CtypeQueryVo;

public interface CtypeCustomMapper {
	// 柜体类型查询
	public List<CtypeCustom> findCtypeList(CtypeQueryVo ctypeQueryVo)
			throws Exception;

	// 查询柜体类型总条数
	public int findCtypeCount(CtypeQueryVo ctypeQueryVo) throws Exception;
}
