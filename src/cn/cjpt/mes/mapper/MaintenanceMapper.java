package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Maintenance;
import cn.cjpt.mes.pojo.po.MaintenanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaintenanceMapper {
	int countByExample(MaintenanceExample example);

	int deleteByExample(MaintenanceExample example);

	int deleteByPrimaryKey(String id);

	int insert(Maintenance record);

	int insertSelective(Maintenance record);

	List<Maintenance> selectByExample(MaintenanceExample example);

	Maintenance selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Maintenance record,
			@Param("example") MaintenanceExample example);

	int updateByExample(@Param("record") Maintenance record,
			@Param("example") MaintenanceExample example);

	int updateByPrimaryKeySelective(Maintenance record);

	int updateByPrimaryKey(Maintenance record);
}