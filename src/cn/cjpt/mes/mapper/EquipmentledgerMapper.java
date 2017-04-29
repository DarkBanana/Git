package cn.cjpt.mes.mapper;

import cn.cjpt.mes.pojo.po.Equipmentledger;
import cn.cjpt.mes.pojo.po.EquipmentledgerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentledgerMapper {
	int countByExample(EquipmentledgerExample example);

	int deleteByExample(EquipmentledgerExample example);

	int deleteByPrimaryKey(String id);

	int insert(Equipmentledger record);

	int insertSelective(Equipmentledger record);

	List<Equipmentledger> selectByExample(EquipmentledgerExample example);

	Equipmentledger selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Equipmentledger record,
			@Param("example") EquipmentledgerExample example);

	int updateByExample(@Param("record") Equipmentledger record,
			@Param("example") EquipmentledgerExample example);

	int updateByPrimaryKeySelective(Equipmentledger record);

	int updateByPrimaryKey(Equipmentledger record);
}