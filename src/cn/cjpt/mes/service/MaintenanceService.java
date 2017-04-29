package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.Maintenance;
import cn.cjpt.mes.pojo.vo.ActiveMaintenance;
import cn.cjpt.mes.pojo.vo.MaintenanceCustom;
import cn.cjpt.mes.pojo.vo.MaintenanceQueryVo;

public interface MaintenanceService {
	public List<MaintenanceCustom> findMaintenanceList(
			MaintenanceQueryVo maintenanceQueryVo) throws Exception;

	public int findMaintenanceCount(MaintenanceQueryVo maintenanceQueryVo)
			throws Exception;

	public Maintenance findMaintenanceByid(String id) throws Exception;

	public ActiveMaintenance checkMaintenanceInfo(String id,
			String maintenancenumber) throws Exception;

	public MaintenanceCustom findMaintenanceById(String id) throws Exception;

	public void updateMaintenance(String id, MaintenanceCustom maintenanceCustom)
			throws Exception;

	public void deleteMaintenance(String id) throws Exception;

	public void insertMaintenance(MaintenanceCustom maintenanceCustom)
			throws Exception;
}
