package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.ToolmanagementCustom;
import cn.cjpt.mes.pojo.vo.ToolmanagementQueryVo;

/**
 * 自定义的ToolmanagementMapper，便于扩展
 * 
 * @author qiaorenjie
 * 
 */
public interface ToolmanagementMapperCustom {

	public List<ToolmanagementCustom> findToolmanagementList(
			ToolmanagementQueryVo toolmanagementQueryVo) throws Exception;

	public int findToolmanagementCount(
			ToolmanagementQueryVo toolmanagementQueryVo) throws Exception;
}
