package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.Equipmentledger;
import cn.cjpt.mes.pojo.vo.ActiveEquipmentledger;
import cn.cjpt.mes.pojo.vo.EquipmentledgerCustom;
import cn.cjpt.mes.pojo.vo.EquipmentledgerQueryVo;

public interface EquipmentledgerService {
	public List<EquipmentledgerCustom> findEquipmentledgerList(
			EquipmentledgerQueryVo equipmentledgerQueryVo) throws Exception;

	public int findEquipmentledgerCount(
			EquipmentledgerQueryVo equipmentledgerQueryVo) throws Exception;

	public Equipmentledger findEquipmentledgerByid(String id) throws Exception;

	public ActiveEquipmentledger checkEquipmentledgerInfo(String id,
			String equipmentledgernumber) throws Exception;

	public EquipmentledgerCustom findEquipmentledgerById(String id)
			throws Exception;

	public void updateEquipmentledger(String id,
			EquipmentledgerCustom equipmentledgerCustom) throws Exception;

	public void deleteEquipmentledger(String id) throws Exception;

	public void insertEquipmentledger(
			EquipmentledgerCustom equipmentledgerCustom) throws Exception;
}
