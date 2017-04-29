package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.Toolmanagement;
import cn.cjpt.mes.pojo.vo.ActiveToolmanagement;
import cn.cjpt.mes.pojo.vo.ToolmanagementCustom;
import cn.cjpt.mes.pojo.vo.ToolmanagementQueryVo;

public interface ToolmanagementService {
	public List<ToolmanagementCustom> findToolmanagementList(
			ToolmanagementQueryVo toolmanagementQueryVo) throws Exception;

	public int findToolmanagementCount(
			ToolmanagementQueryVo toolmanagementQueryVo) throws Exception;

	public Toolmanagement findToolmanagementByid(String id) throws Exception;

	public ActiveToolmanagement checkToolmanagementInfo(String id,
			String toolmanagementnumber) throws Exception;

	public ToolmanagementCustom findToolmanagementById(String id)
			throws Exception;

	public void updateToolmanagement(String id,
			ToolmanagementCustom toolmanagementCustom) throws Exception;

	public void deleteToolmanagement(String id) throws Exception;

	public void insertToolmanagement(ToolmanagementCustom toolmanagementCustom)
			throws Exception;
}
