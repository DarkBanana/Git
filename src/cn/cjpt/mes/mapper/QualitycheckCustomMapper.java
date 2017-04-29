package cn.cjpt.mes.mapper;

import java.util.List;

import cn.cjpt.mes.pojo.vo.MaintenanceCustom;
import cn.cjpt.mes.pojo.vo.MaintenanceQueryVo;
import cn.cjpt.mes.pojo.vo.QualitycheckCustom;
import cn.cjpt.mes.pojo.vo.QualitycheckQueryVo;

public interface QualitycheckCustomMapper {

	public List<QualitycheckCustom> findQualitycheckList(
			QualitycheckQueryVo qualitycheckQueryVo) throws Exception;

	public int findQualitycheckCount(QualitycheckQueryVo qualitycheckQueryVo)
			throws Exception;
}
