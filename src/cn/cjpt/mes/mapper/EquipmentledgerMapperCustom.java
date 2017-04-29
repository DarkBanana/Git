package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.EquipmentledgerCustom;
import cn.cjpt.mes.pojo.vo.EquipmentledgerQueryVo;

/**
 * 自定义的EquipmentledgerMapper，便于扩展
 * 
 * @author qiaorenjie
 * 
 */
public interface EquipmentledgerMapperCustom {

	public List<EquipmentledgerCustom> findEquipmentledgerList(
			EquipmentledgerQueryVo equipmentledgerQueryVo) throws Exception;

	public int findEquipmentledgerCount(
			EquipmentledgerQueryVo equipmentledgerQueryVo) throws Exception;
}
