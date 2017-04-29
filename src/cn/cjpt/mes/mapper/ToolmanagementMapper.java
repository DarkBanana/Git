package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Toolmanagement;
import cn.cjpt.mes.pojo.po.ToolmanagementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ToolmanagementMapper {
	int countByExample(ToolmanagementExample example);

	int deleteByExample(ToolmanagementExample example);

	int deleteByPrimaryKey(String id);

	int insert(Toolmanagement record);

	int insertSelective(Toolmanagement record);

	List<Toolmanagement> selectByExample(ToolmanagementExample example);

	Toolmanagement selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Toolmanagement record,
			@Param("example") ToolmanagementExample example);

	int updateByExample(@Param("record") Toolmanagement record,
			@Param("example") ToolmanagementExample example);

	int updateByPrimaryKeySelective(Toolmanagement record);

	int updateByPrimaryKey(Toolmanagement record);
}