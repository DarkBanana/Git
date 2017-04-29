package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.SysPermission;
import cn.cjpt.mes.pojo.po.SysPermissionExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper {
	int countByExample(SysPermissionExample example);

	int deleteByExample(SysPermissionExample example);

	int deleteByPrimaryKey(BigDecimal id);

	int insert(SysPermission record);

	int insertSelective(SysPermission record);

	List<SysPermission> selectByExample(SysPermissionExample example);

	SysPermission selectByPrimaryKey(BigDecimal id);

	int updateByExampleSelective(@Param("record") SysPermission record,
			@Param("example") SysPermissionExample example);

	int updateByExample(@Param("record") SysPermission record,
			@Param("example") SysPermissionExample example);

	int updateByPrimaryKeySelective(SysPermission record);

	int updateByPrimaryKey(SysPermission record);
}