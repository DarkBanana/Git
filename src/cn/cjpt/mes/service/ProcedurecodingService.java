package cn.cjpt.mes.service;

import java.util.List;

import cn.cjpt.mes.pojo.po.Procedurecoding;
import cn.cjpt.mes.pojo.vo.ActiveProcedurecoding;
import cn.cjpt.mes.pojo.vo.ProcedurecodingCustom;
import cn.cjpt.mes.pojo.vo.ProcedurecodingQueryVo;

public interface ProcedurecodingService {
	public List<ProcedurecodingCustom> findProcedurecodingList(
			ProcedurecodingQueryVo procedurecodingQueryVo) throws Exception;

	public int findProcedurecodingCount(
			ProcedurecodingQueryVo procedurecodingQueryVo) throws Exception;

	public Procedurecoding findProcedurecodingByid(String id) throws Exception;

	public ActiveProcedurecoding checkProcedurecodingInfo(String id,
			String procedurecodingnumber) throws Exception;

	public ProcedurecodingCustom findProcedurecodingById(String id)
			throws Exception;

	public void updateProcedurecoding(String id,
			ProcedurecodingCustom procedurecodingCustom) throws Exception;

	public void deleteProcedurecoding(String id) throws Exception;

	public void insertProcedurecoding(
			ProcedurecodingCustom procedurecodingCustom) throws Exception;
}
