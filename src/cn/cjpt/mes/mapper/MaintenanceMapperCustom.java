package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.MaintenanceCustom;
import cn.cjpt.mes.pojo.vo.MaintenanceQueryVo;

/**
 * 自定义的MaintenanceMapper，便于扩展
 * 
 * @author qiaorenjie
 * 
 */
public interface MaintenanceMapperCustom {

	public List<MaintenanceCustom> findMaintenanceList(
			MaintenanceQueryVo maintenanceQueryVo) throws Exception;

	public int findMaintenanceCount(MaintenanceQueryVo maintenanceQueryVo)
			throws Exception;
}
