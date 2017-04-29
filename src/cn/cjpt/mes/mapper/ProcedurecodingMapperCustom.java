package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.ProcedurecodingCustom;
import cn.cjpt.mes.pojo.vo.ProcedurecodingQueryVo;

/**
 * 自定义的ProcedurecodingMapper便于扩展
 */
public interface ProcedurecodingMapperCustom {
	// 查询
	public List<ProcedurecodingCustom> findProcedurecodingList(
			ProcedurecodingQueryVo procedurecodingQueryVo) throws Exception;

	// 查询
	public int findProcedurecodingCount(
			ProcedurecodingQueryVo procedurecodingQueryVo) throws Exception;

	// 查询在制品时间范围内的部件已完成总数
	public int findScheduleCount(ProcedurecodingQueryVo procedurecodingQueryVo)
			throws Exception;

	// 查询在制品时间范围内的部件需要总共完成总数
	public List<ProcedurecodingCustom> findScheduleTotalCount(
			ProcedurecodingQueryVo procedurecodingQueryVo) throws Exception;

	// 查询 部件 已经完成的数量
	public int findMaterialFinishCount(
			ProcedurecodingQueryVo procedurecodingQueryVo) throws Exception;

	// 按工位查询总数
	public int querystationcount(ProcedurecodingQueryVo procedurecodingQueryVo)
			throws Exception;
}
